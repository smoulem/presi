/**
 * Enum representing the different environments on S3*/
enum AwsEnvironments {
    dev('musdev-microservice-jar-s3-bucket', 'musdev-jenkins-s3-uploader'),
    test('mustest-microservice-jar-s3-bucket', 'mustest-jenkins-s3-uploader'),
    preprod('muspreprod-microservice-jar-s3-bucket', 'muspreprod-jenkins-s3-uploader'), // An upgrade of a client's test service
    prod('musprod-microservice-jar-s3-bucket', 'musprod-jenkins-s3-uploader')           // An upgrade of a client's live service

    String bucketName;

    String credentialsName;

    AwsEnvironments(String bucketName, String credentialsName) {
        this.bucketName = bucketName
        this.credentialsName = credentialsName
    }
}

tempDir = "./temp"
nexusBaseUrl = "https://nexus-deployment.services.aquilaheywood.co.uk"
devNexusBaseUrl = "https://nexus-altdev.services.aquilaheywood.co.uk"
microserviceName = "microservice-upgrade-agent"
environments = getAwsEnvironmentValuesList().join("\n")

pipeline {
    agent {
        label 'linux'
    }
    options {
        timestamps()
        buildDiscarder(logRotator(numToKeepStr: '30'))
    }
    parameters {
        choice(name: 'environment', description: 'The environment that the latest MUA version will be deployed to.', choices: environments)
    }
    environment {
        MUA_VERSION = getLatestMicroserviceUpgradeAgentVersion()
    }
    stages {
        stage('Confirm Parameters') {
            options {
                timeout(time: 1, unit: 'HOURS')
            }
            steps {
                script {
                    echo "Requesting confirmation from second user."
                    def confirmParameters = [
                        choice(name: 'environment', description: 'The environment that the latest MUA version will be deployed to.', choices: params.environment),
                        choice(name: 'microserviceUpgradeAgentVersion', description: 'The Microservice Upgrade Agent version that will be deployed to the MUS S3 Bucket.', choices: MUA_VERSION)
                    ]

                    Map authoriser = input message: "Confirm Upgrade?", parameters: confirmParameters, submitterParameter: 'user'
                    echo "Parameters confirmed: ${authoriser}."
                }
            }
        }
        stage('Publish to nexus') {
            steps {
                sh 'chmod 755 gradlew'
                sh './gradlew publishMicroserviceUpgradeAgentToQARepository'
            }
        }

        stage('Copy from dev nexus to deployment nexus') {
            steps {
                script {
                    muaJarName = "${microserviceName}-${microserviceUpgradeAgentVersion}.jar"
                    targetDir = "${tempDir}/dev/${microserviceName}"

                    createTempDirectory(targetDir)
                    getJarFromDevNexus(muaJarName, targetDir, microserviceUpgradeAgentVersion)
                    publishDevJarToDeploymentNexus(muaJarName, targetDir, microserviceUpgradeAgentVersion)
                    deleteDirectory(targetDir)
                }
            }
        }
        stage('Release MicroserviceUpgradeAgent to MUS') {
            steps {
                script {
                    muaJarName = "${microserviceName}-${MUA_VERSION}.jar"
                    targetDir = "${tempDir}/${microserviceName}"

                    createTempDirectories()
                    getJarFromNexus(muaJarName, targetDir, MUA_VERSION)

                    def environment = AwsEnvironments[params.environment]
                    def bucketName = environment.bucketName
                    def credentials = environment.credentialsName

                    withAWS(credentials: credentials, region: 'eu-west-2') {
                        s3Upload(file: targetDir, bucket: bucketName, path: "${microserviceName}/")
                    }
                }
            }
        }
    }
    post {
        always {
            script {
                cleanupTemporaryDirectory()
            }
        }
    }
}

def getAwsEnvironmentValuesList() {
    return AwsEnvironments.values().collect { it.name() }
}

def getLatestMicroserviceUpgradeAgentVersion() {
    def repository = 'releases'
    def groupId = 'uk.co.heywood.services'
    def nexusSearchUrl = "${nexusBaseUrl}/service/rest/v1/search?repository=${repository}&group=${groupId}&name=${microserviceName}&sort=version&direction=desc"

    echo "Retrieving all versions of artifact ${groupId}:${microserviceName} using: ${nexusSearchUrl}"
    def microserviceUpgradeAgentVersionList = getVersions(nexusSearchUrl)
    return microserviceUpgradeAgentVersionList[0]
}

def getVersions(def nexusSearchUrl) {
    def response = httpRequest url: nexusSearchUrl, httpMode: 'GET', quiet: true
    def searchResultsJson = response.getContent()
    Map searchResults = readJSON text: searchResultsJson
    return searchResults['items'].collect { it['version'] }
}

def createTempDirectories() {
    sh "mkdir ${tempDir}"
    sh "mkdir ${tempDir}/${microserviceName}"
}

def getJarFromNexus(def muaJarName, def targetDir, def microserviceUpgradeAgentVersion) {
    def artifactUrl = "${nexusBaseUrl}/repository/releases/uk/co/heywood/services/microservice-upgrade-agent/${microserviceUpgradeAgentVersion}/${muaJarName}"
    targetFile = "${targetDir}/${muaJarName}"
    sh "curl -o ${targetFile} ${artifactUrl}"
}

def cleanupTemporaryDirectory() {
    echo "Deleting folder ${tempDir}"
    sh "rm -r ${tempDir}"
}

def createTempDirectory(dirPath) {
    sh "mkdir -p ${dirPath}"
}

def getJarFromDevNexus(def muaJarName, def targetDir, def microserviceUpgradeAgentVersion) {
    def artifactUrl = "${devNexusBaseUrl}/repository/QA/uk/co/heywood/services/microservice-upgrade-agent/${microserviceUpgradeAgentVersion}/${muaJarName}"
    targetFile = "${targetDir}/${muaJarName}"
    sh "curl ${artifactUrl} -o ${targetFile}"
}

def publishDevJarToDeploymentNexus(muaJarName, targetDir, microserviceUpgradeAgentVersion) {
    def artifactUrl = "${devNexusBaseUrl}/repository}"

    sh """\
    curl \
    -F r=QA \
    -F hasPom=false \
    -F e=jar \
    -F g=uk.co.heywood.services \
    -F a=microservice-upgrade-agent \
    -F v=${microserviceUpgradeAgentVersion} \
    -F p=jar \
    -F file=@${targetDir}/"${muaJarName} \
    ${artifactUrl}
    """.trim()
}

def deleteDirectory(dirPath) {
    echo "Deleting folder ${dirPath}"
    sh "rm -r ${dirPath}"
}


// Use this code snippet in your app.
// If you need more information about configurations or implementing the sample
// code, visit the AWS docs:
// https://docs.aws.amazon.com/sdk-for-java/latest/developer-guide/home.html

// Make sure to import the following packages in your code
// import software.amazon.awssdk.regions.Region;
// import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
// import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest;
// import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueResponse;	

public static void getSecret() {

    String secretName = "pact-write-credentials";
    Region region = Region.of("eu-west-2");

    // Create a Secrets Manager client
    SecretsManagerClient client = SecretsManagerClient.builder()
            .region(region)
            .build();

    GetSecretValueRequest getSecretValueRequest = GetSecretValueRequest.builder()
            .secretId(secretName)
            .build();

    GetSecretValueResponse getSecretValueResponse;

    try {
        getSecretValueResponse = client.getSecretValue(getSecretValueRequest);
    } catch (Exception e) {
        // For a list of exceptions thrown, see
        // https://docs.aws.amazon.com/secretsmanager/latest/apireference/API_GetSecretValue.html
        throw e;
    }

    String secret = getSecretValueResponse.secretString();

    // Your code goes here.
}