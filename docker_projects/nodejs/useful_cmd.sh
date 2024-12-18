docker build -t node-docker ../../empty_folder

docker run --rm -it --name node-docker

docker run --rm -it --name node-docker \
-v $PWD:/home/app -w /home/app \
-e "PORT=3000" -p 8080:3000  \
-u node node:latest /bin/bash

docker-compose run --rm --service-ports nod_dev_env
docker-compose run --rm -p 4000:3000 nod_dev_env
docker-compose up
docker-compose down

yarn init -y
yarn add express
yarn add -D nodemon


# is it useful ??? can do the same with container name:
# docker exec -it node-docker yarn add body-parser
docker ps -qf "name=node-docker"
docker exec -it $(docker ps -qf "name=node-docker") /bin/bash
docker exec -it $(docker ps -qf "name=node-docker") curl localhost:3000
docker exec -it $(docker ps -qf "name=node-docker") yarn add body-parser
