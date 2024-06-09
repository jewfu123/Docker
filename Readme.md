
// ----- 2024-6-8 ------ //
## 常用Docker命令：

#### docker --version

#### docker run hello-world

#### docker image ls

#### docker container ls --all

1. docker --help
2. docker container --help
3. docker container ls --help
4. docker run --help

#### docker run --interactive --tty ubuntu bash

#### docker container ls


#### docker run --detach --publish 80:80 --name webserver nginx
*left:80 is open in win11 right:80 is open in container's application
*left is wide, right is inside.

#### docker container stop webserver

###### Golden rabbit server:)
```shell
docker run -e RABBITMQ_DEFAULT_USER=itcast -e RABBITMQ_DEFAULT_PASS=123321 --name rabbitmq444 --hostname localhost -p 15672:15672 -p 5672:567
2 -d rabbitmq:3-management
```

#### Stop container
docker container stop webserver

#### Delete containers
docker container rm webserver laughing_kowalevski relaxed_sammet



































































































