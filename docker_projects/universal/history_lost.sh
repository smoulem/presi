    1  rsync -vaz terraform ~/.local/bin/
    2  rsync -vaz terragrunt_linux_amd64 ~/.local/bin/terragrunt && chmod u+x ~/.local/bin/terragrunt
    3  terraform --version
    4  terragrunt --version
    5  ./aws/install --bin-dir ~/.local/bin --install-dir ~/.local/aws-cli --update
    6  ls -a ~
    7  ls -alht ~
    8  aws --version
    9  fish ohmyfish_install --noninteractive
   10  fish -c 'omf install agnoster'
   11  fish -c 'omf theme agnoster'
   12  clear
   13  sudo chown -R $(id -u):$(id -g) ~/.aws
   14  ls -alht ~
   15  sudo chown -R $(id -u):$(id -g) ~/.awsume
   16  sudo chown $(id -u):$(id -g) ~/.gitconfig
   17  ls -alht ~
   18  clear
   19  aws sts assume-role --role-arn arn:aws:iam::215265688243:role/mus --role-session-name musmgmt
   20  ls -alht ~/.aws
   21  aws configure
   22  ls -alht ~/.aws
   23  cat ~/.aws/credentials 
   24  aws sts assume-role --role-arn arn:aws:iam::215265688243:role/mus --role-session-name musmgmt
   25  less ~/.aws/config 
   26  aws --profile smoulem sts assume-role --role-arn arn:aws:iam::215265688243:role/mus --role-session-name musmgmt
   27  pipx install awsume
   28  pip install awsume
   29  sudo apt-get install python3-setuptools
   30  alias awsume=". awsume"
   31  awsume musmgmt
   32  pwd
   33  lht
   34  ls -laht
   35  sudo chown -R $(id -u):$(id -g) microservice-upgrade-service-pipeline
   36  ls -laht
   37  ls -laht microservice-upgrade-service-pipeline/
   38  cd microservice-upgrade-service-pipeline/accounts/musmgmt/static/
   39  terragrunt run-all plan
   40  cal
   41  time
   42  date
   43  env
   44  env |grep AWS
   45  history >> history
