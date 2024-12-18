# install(s)
sudo chown -R $(id -u):$(id -g) ~/.awsume
sudo chown -R $(id -u):$(id -g) ~/.aws
#
rsync -vaz terraform ~/.local/bin/
rsync -vaz terragrunt_linux_amd64 ~/.local/bin/terragrunt && chmod u+x ~/.local/bin/terragrunt
terraform --version
terragrunt --version
#
./aws/install --bin-dir ~/.local/bin --install-dir ~/.local/aws-cli --update
aws --version
# needs default - in .aws/credentials - or specify profile smoulem
aws sts assume-role --role-arn arn:aws:iam::215265688243:role/mus --role-session-name musmgmt
aws sts assume-role --role-arn arn:aws:iam::923012622218:role/tf_deployer --role-session-name tf_deployer
#
fish ohmyfish_install --noninteractive
fish -c 'omf install agnoster'
fish -c 'omf theme agnoster'
#
sudo apt update 
sudo apt-get install python3-setuptools
# pip3 install setuptools 
# pip install setuptools
# pip install -U pip setuptools
# python3 -m pip install --upgrade pip setuptools wheel
# pip install awsume
# pip3 install awsume
pipx install awsume
alias awsume=". awsume"
# awsume-configure --shell fish

## oh my fish
wget -O ohmyfish_install https://raw.githubusercontent.com/oh-my-fish/oh-my-fish/master/bin/install
fish ohmyfish_install --noninteractive
# rm ohmyfish_install
## theme agnoster - fish
fish -c 'omf install agnoster'
fish -c 'omf theme agnoster'
##
eval (ssh-agent -c)
eval (ssh-agent -s)
abbr -a cl clear
##
docker cp .aws wonderful_proskuriakova:/home/codespace/
docker cp .awsume wonderful_proskuriakova:/home/codespace/
docker cp .gitconfig wonderful_proskuriakova:/home/codespace/
sudo chown -R $(id -u):$(id -g) ~/.aws
sudo chown -R $(id -u):$(id -g) ~/.awsume
sudo chown $(id -u):$(id -g) ~/.gitconfig
docker cp microservice-upgrade-service-pipeline wonderful_proskuriakova:/workspaces/universal/
sudo chown -R $(id -u):$(id -g) microservice-upgrade-service-pipeline
##

##
sdk i java 17.0.12-amzn
sudo apt update
sudo apt install fish
##

# rm -rf aws 
rm awscliv2.zip
aws --version
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
./aws/install --bin-dir ~/.local/bin --install-dir ~/.local/aws-cli --update

rm terraform_1.9.3_linux_amd64.zip LICENSE.txt
ls -lth
cat ~/.bashrc
alias | grep awsume
pipx install awsume
terragrunt --version
mv ~/.local/bin/{terragrunt_linux_amd64,terragrunt}
terragrunt_linux_amd64 --version
terraform --version
mv terraform ~/.local/bin/
./terraform --version
unzip terraform_1.9.3_linux_amd64.zip
mv terragrunt_linux_amd64  ~/.local/bin/
./terragrunt_linux_amd64 --version
chmod u+x terragrunt_linux_amd64
./terragrunt_linux_amd64
echo $PATH
wget https://releases.hashicorp.com/terraform/1.9.3/terraform_1.9.3_linux_amd64.zip
file terragrunt_linux_amd64
ls -h
wget https://github.com/gruntwork-io/terragrunt/releases/download/v0.66.1/terragrunt_linux_amd64
java -version
git -v
docker ps -a
history >> history
history
ls -laht ~
ls -lht ~
sudo chown -R 1000:1000 ~/.awsume
whoami
who
sudo chown -R 1000:1000 ~/.aws
sudo chown -r 1000:1000 ~/.aws
echo $a
set a (id -u)
id -g
id -u
sudo su
la ~
aws sts assume-role --role-arn arn:aws:iam::215265688243:role/mus --role-session-name musmgmt
clear
awsume musmgmt
awsume-configure
alias awsume=". awsume"
awsume musmgmt
pip3 install colorama
exit
awsume musmgmt
exit
aws sts assume-role --role-arn arn:aws:iam::215265688243:role/mus --role-session-name musmgmt
exit
history
history >> history
