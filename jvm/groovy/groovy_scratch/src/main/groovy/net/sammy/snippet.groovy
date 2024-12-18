tempDir = "./temp"
devDir = new File("${tempDir}/dev/mua")
devDir.mkdirs()
devNexusBaseUrl = "https://nexus-altdev.services.aquilaheywood.co.uk"
microserviceUpgradeAgentVersion = "1.0.52"
muaJarName = "microservice-upgrade-agent-1.0.52.jar"

artifactUrl = "${devNexusBaseUrl}/repository/QA/uk/co/heywood/services/microservice-upgrade-agent/${microserviceUpgradeAgentVersion}/${muaJarName}"
targetFile = "${devDir}/${muaJarName}"

smStdout = new StringBuilder()
smStderror = new StringBuilder()

curlComm = "curl ${artifactUrl} -o ${targetFile}".execute()
curlComm.consumeProcessOutput(smStdout, smStderror)
curlComm.waitForOrKill(1000)

println "###"
println "out: ${smStdout} \n errors: ${smStderror}"
println "###"

myOut = new StringBuilder()
myError = new StringBuilder()

lsComm = "ls -lh ${targetFile}".execute()
lsComm.consumeProcessOutput(myOut, myError)
lsComm.waitForOrKill(1000)

println "***"
println "out: ${myOut} \n errors: ${myError}"
println "***"

new File(targetFile).delete()
devDir.delete()

////

def response = httpRequest (url: "${artifactUrl}",
        httpMode: 'POST',
        quiet: true,
        formData: paramMap)

//-u admin:admin123 \

//def paramMap = [
//        authentication:"credentialsId"
//        ignoreSslErrors:"true",
//        r:"QA",
//        hasPom:"false",
//        e:"jar",
//        g:"uk.co.heywood.services",
//        a:"microservice-upgrade-agent",
//        v:microserviceUpgradeAgentVersion,
//        p:"jar",
//        uploadFile:@"${targetDir}/"${muaJarName}"
//]
