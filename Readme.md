
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

// -------- DockerCE install on >Centos7.3 commands -------------- //
remove before install
>yum remove docker \
>   docker-client \
>   docker-client-latest \
>   docker-common \
>   docker-latest \
>   docker-latest-logrotate \
>   docker-selinux \
>   docker-engine-selinux \
>   docker-engine \
>   docker-ce

install yum plugin
>yum install -y yum-utils \
>            device-mapper-persistent-data \
>            lvm2 --skip-broken

update host local image src url: set docker image src
>yum-config-manager \
>     --add-repo \
>     https://mirrors.aliyun.com/docker-ce/linux/centos/docker-ce.repo
>
>sed -i 's/download.docker.com/mirrors.aliyun.com\/docker-ce/g'/etc/yum.repos.d/docker-ce.repo
>
>yum makecache fast

install docker
>yum install -y docker-ce
>
stop firewall commands:
>systemctl stop firewalld
>systemctl disable firewalld
>

start docker ce:
>systemctl start docker
>docker -v

set image fast speed setting:
>sudo mkdir -p /etc/docker
>sudo tee /tc/docker/daemon.json <<-'EOF'
{
  "registry-mirrors": ["https://n0dwemtq.mirror.aliyuncs.com"]
}
EOF
>sudo systemctl daemon-reload
>sudo systemctl restart docker

docker images commands:
>docker images
>docker save -o nginx.tar nginx:latest or tagno
>docker rmi nginx:latest
>docker load -i nginx.tar

more commands about docker image:
>docker images
>docker rmi
>docker pull
>docker push
>docker save
>docker load

docker container:
>docker run
>docker pause <--> docker unpause
>docker start <--> docker stop
>docker exec ---> go into contain and run command
>docker logs
>docker ps
-----
>docker run --name containerName -p 80:80 -d nginx  [left 80 is host][-d backend running]
>docker exec -it containerName bash [bash<mean jiaohu> can be command name self]
*unsugest modify in container and normal in host path with join volumne on container.

start and rm/stop container:
>docker start mn
>docker rm -f mn
>docker stop mn

>docker ps -a
>docker pull redis
>docker run --name mr -p 6379:6379 -d redis redis-server --appendonly yes
>docker exec -it bash
or docker exec -it mr redis-cli -> skip below
>redis-cli
>set num 666

redis-cli -h 192.168.150.157 -p 6379
>get keys
>get num
--> show 666

docker with volume commands:
>docker volume create/inspect/ls/prune/rm
>docker run --name mn -p 80:80 -v html:/usr/share/nginx/html -d nginx
*if html is not exist then be created auto.

























































































