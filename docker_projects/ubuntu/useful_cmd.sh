# https://github.com/nodejs/devcontainer

container_name='ubuntu-node'
docker build -t "${container_name}:dev" ../../empty_folder
docker run --rm -it --name $container_name

bind_mount="-v $PWD:/home/developer/nodejs/node"
docker run --rm -it --name $container_name \
$bind_mount \
"${container_name}:dev" /bin/bash
