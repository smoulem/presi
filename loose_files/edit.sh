 awk '/The connection has timed out/' xps\ logs/altairmain-wrapper.log.5
  506  ls
  507  ls Kent_inc153492
  508  find Kent_inc153492 - name "altair*.log*" | xargs awk '/timed out/'
  509  find Kent_inc153492 -name "altair*.log*" | xargs awk '/timed out/'
  510  find Kent_inc153492 -name "altair*.log*" | xargs awk '/timed out/' > kent_timed_out_altair.log
  511  find Kent_inc153492 -name "altair*.log*" | xargs awk '/timed out/ { print($0 " " FILENAME) }' > kent_timed_out_altair.log
  512* find Kent_inc153492 -name "altair*.log*" | xargs awk '/timed out/ { print($0 " " FILENAME) ":" FNR }' > kent_timed_out_altair.log
  513  ls
  514  pwd
  515  ls xps\ logs
  516  ls
  517  ls
  518  ls xps\ logs
  519  wc -l xps\ logs/output.log


#
docker pull ghcr.io/oracle/oraclelinux8-instantclient:19

winpty docker run \
-e ORACLE_SID=CHFDB01 \
-ti \
--rm \
ghcr.io/oracle/oraclelinux8-instantclient:19 \
sqlplus ALTAIR@alt-smoulem.altdev.ahnet.co.uk:3521/CHFDB01


docker cp news.zip affectionate_bartik:/home/vscode/projects/
docker cp ~/.aws affectionate_bartik:/home/vscode/
docker cp ~/.awsume affectionate_bartik:/home/vscode/
docker cp ~/.gitconfig affectionate_bartik:/home/vscode/
docker cp Heywood.xml nostalgic_gauss:/root/
alias lht='ls -lath'
sudo chown -R $(id -u):$(id -g) ~/.aws
sudo chown -R $(id -u):$(id -g) ~/.awsume
sudo chown -R $(id -u):$(id -g) ~/.gitconfig
su vscode -
sudo chown -R $(id -u):$(id -g) {.aws,.awsume,.gitconfig}

alias py=python3
sudo apt update
sudo apt install pipx
pipx ensurepath
sudo pipx ensurepath --global # optional to allow pipx actions in global scope. See "Global installation" section below.

sudo apt update
sudo apt install tmux wget

winpty docker run -it --name tumble sammy/opensuse fish

docker run -rm -it --name mynode node:lts-bullseye
# from /c/projects/git/microservice-upgrade-service
docker run --rm -it -d --mount type=bind,source="$PWD",target=/home/node --name mynode node:lts-bullseye

docker pull node:lts-bookworm

## https://github.com/AlDanial/cloc
# git-bash
docker run --rm -v "/$(pwd -W)":/tmp aldanial/cloc <files/dir>
for d in ./*/ ; do (cd "$d" && echo "$d" && cloc --vcs git); done
# windows
docker run --rm -v $PWD:/tmp aldanial/cloc <files/dir>
for /D %I in (.\*) do cd %I && cloc --vcs git && cd ..

# tfsec
wget https://github.com/aquasecurity/tfsec/releases/download/v1.28.10/tfsec-checkgen-linux-amd64
touch ~/.bashrc 
brew install terragrunt
terragrunt --install-autocomplete

## devcontainers.json
    "mounts": [
    "type=bind,source=/c/Users/smoulem/.ssh,target=/home/codespace/.ssh,readonly",
    "type=bind,source=/c/Users/smoulem/.gitconfig,target=/home/codespace/.gitconfig,readonly",
    "type=bind,source=/c/Users/smoulem/.awsume,target=/home/codespace/.awsume,readonly",
    "type=bind,source=/c/Users/smoulem/.aws,target=/home/codespace/.aws,readonly"
  ],

  # settings
  "java.configuration.runtimes": [
  {
    "name": "JavaSE-1.8",
    "path": "/path/to/jdk-8",
  },
  {
    "name": "JavaSE-11",
    "path": "/path/to/jdk-11",
  },
  {
    "name": "JavaSE-22",
    "path": "/path/to/jdk-22",
    "default": true
  },
]

# extensions
vscode:extension/vscjava.vscode-java-pack
vscode:extension/vmware.vscode-boot-dev-pack
https://marketplace.visualstudio.com/items?itemName=MicroProfile-Community.vscode-microprofile-pack
https://marketplace.visualstudio.com/items?itemName=redhat.vscode-quarkus
https://marketplace.visualstudio.com/items?itemName=alphabotsec.vscode-eclipse-keybindings
https://marketplace.visualstudio.com/items?itemName=k--kato.intellij-idea-keybindings
https://marketplace.visualstudio.com/items?itemName=ms-kubernetes-tools.vscode-kubernetes-tools
https://marketplace.visualstudio.com/items?itemName=MS-vsliveshare.vsliveshare
https://marketplace.visualstudio.com/items?itemName=redhat.java

## 
export PACT_BROKER_USERNAME="heywood-pact-write"
export PACT_BROKER_PASSWORD="8qVsqmwAn1oZwX+3"

envname=mustest

docker run \
--name pact-cli \
--broker-base-url https://pact.mustest.hptcloud.co.uk \
--broker-username ${PACT_BROKER_USERNAME} \
--broker-password ${PACT_BROKER_PASSWORD} \
pactfoundation/pact-cli:latest \
pact-broker create-environment --name uat --display-name UAT --no-production

UUID                                 | NAME    | DISPLAY NAME | PRODUCTION
-------------------------------------|---------|--------------|-----------
ea366968-e902-4259-9088-48a73c6b8aef | dev     | Dev          | false
1b9ac390-5d5e-48eb-83e3-31592f11bf55 | preprod | Preprod      | false
4bf94f09-8cf8-459f-9bf8-853addfa87b2 | prod    | Prod         | true
8a3d18fa-35fe-445c-b894-67050c191c55 | test    | Test         | false
# 


awk '{print $6 " " $7 "," $13 "," $15 "," $18 "," $20}'


phases:
  install:
    commands:
      - aws configure set role_arn arn:aws:iam::${MUSTEST_ACCOUNT_ID}:role/tf_deployer

export PACT_BROKER_USERNAME=$(aws secretsmanager get-secret-value --secret-id pact-write-credentials --query 'SecretString' --output text | jq '.username' | tr -d \")
export PACT_BROKER_PASSWORD=$(aws secretsmanager get-secret-value --secret-id pact-write-credentials --query 'SecretString' --output text | jq '.password' | tr -d \")
echo $PACT_BROKER_USERNAME
echo $PACT_BROKER_PASSWORD

aws configure set role_arn arn:aws:iam::923012622218:role/tf_deployer
export PACT_BROKER_USERNAME=$(aws secretsmanager get-secret-value --secret-id arn:aws:secretsmanager:eu-west-2:923012622218:secret:pact-write-credentials-eCEruG --query 'SecretString' --output text | jq '.username' | tr -d \")
export PACT_BROKER_PASSWORD=$(aws secretsmanager get-secret-value --secret-id arn:aws:secretsmanager:eu-west-2:923012622218:secret:pact-write-credentials-eCEruG --query 'SecretString' --output text | jq '.password' | tr -d \")


withAWS(credentials: 'pact-broker-write', region: 'eu-west-2') {
                    script {
                        def cmd = """\
export PACT_BROKER_BASE_URL="https://pact.mustest.hptcloud.co.uk"
export PACT_BROKER_USERNAME="heywood-pact-write"
export PACT_BROKER_PASSWORD="8qVsqmwAn1oZwX+3"
export GIT_COMMIT=${env.GIT_COMMIT}
export WORKSPACE=${WORKSPACE}
docker-compose up
""".trim()
                        
                        sh cmd

//                        def containerImage = "pactfoundation/pact-cli:latest"
//                        def brokerUrl = "https://pact.mustest.hptcloud.co.uk"
//                        def userName = "heywood-pact-write"
//                        def password = "8qVsqmwAn1oZwX+3"
//                        def cmd = """\
//docker run -v ${WORKSPACE}/build/pacts:/pacts ${containerImage} \
//pact-broker publish /pacts \
//--broker-base-url ${brokerUrl} \
//--broker-username ${userName} \
//--broker-password ${password} \
//--consumer-app-version 1.0.1
//""".trim()

//                        sh cmd
                    }
                }



 target_ip='10.7.56.255'
# Rerun UI Tests (Chrome)  al-l-1103.altdev.ahnet.co.uk alt-smoulem.altdev.ahnet.co.uk # 10.7.56.69
./gradlew :AltairCucumberFramework:clean :AltairCucumberFramework:runUiTests \
--refresh-dependencies \
-DBranch=raya \
-DHosts=$target_ip \
-DCobolFree=false \
-Dbrowser=Chrome \
-DuseSeleniumGrid=true \
-DmailHost=cx-d-kub-t-11.altdev.ahnet.co.uk \
-DmailPort=30725 \
--tests WorkflowBulkCompleteProcessTest --tests GetClaimOperationJavaTest --tests GetClaimOperationJavaTest 
--tests GetClaimOperationJavaTest --tests BalanceEnquiryEmailTest --tests BalanceEnquiryEmailTest 
--tests BalanceEnquiryEmailTest --tests CorporateGmpFieldsCobolTest --tests MemberCommsPrefsTest 
--tests EmpGMPDVTest --tests EmpSpecialContsTest



./gradlew :AltairRegressionTesting:runRegressionTests --refresh-dependencies -DBranch=integration \
-DHosts=10.7.56.255 \
-DCobolFree=true -Dbrowser=Chrome -DuseSeleniumGrid=true  1>TestLogs.txt 


[alias]
    # one-line log
    l = log --pretty=format:"%C(yellow)%h\\ %ad%Cred%d\\ %Creset%s%Cblue\\ [%cn]" --decorate --date=short

    a = add
    ap = add -p
    c = commit --verbose
    ca = commit -a --verbose
    cm = commit -m
    cam = commit -a -m
    m = commit --amend --verbose
    
    d = diff
    ds = diff --stat
    dc = diff --cached

    s = status -s
    co = checkout
    cob = checkout -b
    # list branches sorted by last modified
    b = "!git for-each-ref --sort='-authordate' --format='%(authordate)%09%(objectname:short)%09%(refname)' refs/heads | sed -e 's-refs/heads/--'"

    # list aliases
    la = "!git config -l | grep alias | cut -c 7-"



# https://www.digitalocean.com/community/tutorials/how-to-remove-docker-images-containers-and-volumes
docker system prune
docker system prune -a
docker images -a
docker rmi Image Image
docker images -f dangling=true
docker image prune
docker images -a |  grep "pattern"
docker images -a | grep "pattern" | awk '{print $1":"$2}' | xargs docker rmi
docker images -a
docker rmi $(docker images -a -q)
docker ps -a
docker rm ID_or_Name ID_or_Name
docker run --rm image_name
docker ps -a -f status=exited
docker rm $(docker ps -a -f status=exited -q)
docker ps -a -f status=exited -f status=created
docker rm $(docker ps -a -f status=exited -f status=created -q)
docker ps -a |  grep "pattern"
docker ps -a | grep "pattern" | awk '{print $1}' | xargs docker rm
docker ps -a
docker stop $(docker ps -a -q)
docker rm $(docker ps -a -q)
docker volume ls
docker volume rm volume_name volume_name
docker volume ls -f dangling=true
docker volume prune
docker rm -v container_name


docker-compose up  # does build the docker image
git checkout -b SM_ADMN_26627
git push -u origin SM_ADMN_26627
docker build -t nexus-altdev.services.aquilaheywood.co.uk/jenkins:SM_ADMN_26627 .
docker push nexus-altdev.services.aquilaheywood.co.uk/jenkins:SM_ADMN_26627

docker run --rm -p 7777:8080 --name xxx jenkins/jenkins:lts-alpine
#******* bug fix - no class def exception 01/10/2024 *******
# build container set plugin versions to what is specified in plugins.txt
JENKINS_VERSION='lts-alpine' 
docker build --no-cache -f Dockerfile-update --build-arg JENKINS_VERSION=${JENKINS_VERSION} -t jenkins-update .
docker run --name sm-jenkins-update-container jenkins-update
# run above image, update plugins to latest version, spit out an updated plugins.txt
docker-compose -f docker-compose.plugins.yml up

docker build --no-cache -t nexus-altdev.services.aquilaheywood.co.uk/jenkins:sm_local .
docker run --name sm-jenkins-check-container -p 8888:8080 nexus-altdev.services.aquilaheywood.co.uk/jenkins:2.0.9
#******* bug fix - no class def exception 01/10/2024 *******


docker run -d -v jenkins_lts_alpine_home:/var/jenkins_home -p 8888:8080 -p 55555:50000 jenkins/jenkins:lts-alpine
docker logs 8662f9d886138ea79f57ba60b062212d15e615b5b7c4d55fc6e0d2b15f83f217
docker ps
ls -a
docker ps
docker cp .kube nervous_einstein:/home/codespace

PR ADMN-26627 - sparseCheckout

SM_ADMN_26627
sparseCheckout
ADMN-26627 Replace sparseCheckout with heywoodCheckout
https://git.services.aquilaheywood.co.uk/scm/al/altair-testing.git
grep -Rl 'sparseCheckout(' . | xargs sed -i 's/sparseCheckout(/heywoodCheckout(/g'
grep -Rl 'sparseCheckout (' . | xargs sed -i 's/sparseCheckout (/heywoodCheckout (/g'

git checkout -b SM_ADMN_26627
grep -Rl 'sparseCheckout(' .
grep -Rl 'sparseCheckout(' . | grep -v '.pack' | xargs sed -i 's/sparseCheckout(/heywoodCheckout(/g'
git push -u origin SM_ADMN_26627

grep -rl 'sparseCheckout' . 
##
https://git.services.aquilaheywood.co.uk/scm/ahdp/jenkins-deep-dive.git
automation bitbucket credentials 
*
pipelines/gavinsPipeline.groovy
#
https://git.services.aquilaheywood.co.uk/scm/~smoulem/fork_calcs.git
*               # for multi branch 
*/SM_ADMN_26627 # for single branch
- none credentials 
CalcsBuild/pipelineScripts/calcsCiPipeline.groovy
##

nexus-altdev.services.aquilaheywood.co.uk/jenkins:staging
#
# https://issues.jenkins.io/browse/JENKINS-55436
# pipeline is what it is and does some things, other have to be done manually
# did the upgrade on wednesday
## debug 03/10/2024
# debug / change the dockerfile
# jenkins configuration, shared libraries, plugins
# check / change the various plugins version, specifically workflow
# remove deprecatd plugin 
# track cps, jenkins core, check other workflow plugin versions release notes
# debug shared library
# debug pipeline script
docker run --name sm-jenkins-check-container -p 8888:8080 nexus-altdev.services.aquilaheywood.co.uk/jenkins:2.0.9
docker build -t jenkins:replace_workflow_cps_global . 
docker run --rm --name sm-workflow-cps -p 9999:8080 jenkins:replace_workflow_cps_global

tag='replace_workflow_cps_global'
tag='remove_pipeline_declarative'
tag='downgrade_cps' 
tag='downgrade_script_security'
tag='remove_script_security'
tag='2.462.3-lts-alpine'
tag='2.462.1-lts-alpine'
tag='2.456-alpine' # :(

echo "tag => $tag" 

container_name="sm_${tag#jenkins:}"
echo "container_name => $container_name" 

docker build --no-cache -t "jenkins:$tag" . 
docker images | grep jenkins

docker run --rm --name $container_name -p 9999:8080 $tag

# edit image to jenkins:replace_workflow_cps_global in dev-compose.yml 
./ runDevJenkins.sh
## debug 


## plan to upgrade Jenkins
# before doing anything: backup and tag - on your local machine - the existing Docker image 
docker pull nexus-altdev.services.aquilaheywood.co.uk/jenkins:latest
docker tag nexus-altdev.services.aquilaheywood.co.uk/jenkins:{latest,previous-stable}
# run the pipeline to create a upgraded Docker image. 
# pull and tag the new image; push it to the registry with tag 'latest'
# then run the pipeline to delete existing jenins Kubernetes pod
docker pull nexus-altdev.services.aquilaheywood.co.uk/jenkins:staging 
docker tag nexus-altdev.services.aquilaheywood.co.uk/jenkins:{staging,latest}
docker images | grep jenkins
docker push nexus-altdev.services.aquilaheywood.co.uk/jenkins:latest
# Rollback!!
# on your local machine, tag the backup image with 'latest'
# push tagged image to registry
# run the pipeline to delete existing jenins Kubernetes pod
docker tag nexus-altdev.services.aquilaheywood.co.uk/jenkins:{previous-stable,latest}
docker push nexus-altdev.services.aquilaheywood.co.uk/jenkins:latest

##
mytag='housekeeping'
set mytag housekeeping
docker build -f Dockerfile-update --build-arg JENKINS_VERSION=2.462.2-lts-alpine . -t nexus-altdev.services.aquilaheywood.co.uk/jenkins:$mytag 
docker push nexus-altdev.services.aquilaheywood.co.uk/jenkins:$mytag 
