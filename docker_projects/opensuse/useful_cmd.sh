source="/c/projects"
target="/home/opensuse"
bind_mount="--mount type=bind,source=${source},target=${target}"

winpty docker run -it $bind_mount --name tumble sammy/opensuse fish
#
git config --global --add safe.directory /home/opensuse/other_projects/jvm/java/code-wars
#
docker stop tumble
docker rm tumble
#
source="opensuse_data"
target="/home/opensuse/app"
_mount="--mount source=${source},target=${target}"
winpty docker run -it $_mount --name tumble sammy/opensuse fish

winpty docker run -it --mount source='opensuse_data',target='/home/opensuse/app' --name tumble sammy/opensuse fish
winpty docker run -it --volume 'opensuse_data:/home/opensuse/app' --name tumble sammy/opensuse fish

winpty docker run -it --name tumble sammy/opensuse fish
#
winpty docker attach tumble
winpty docker exec -it tumble fish
#
cd empty_folder/
ln -s ~/.ssh
docker build -f docker_projects/opensuse/opensuse_dockerfile -t sammy/opensuse:latest ./empty_folder/

##
sdk install java 17.0.11-amzn