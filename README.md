###这是一个简单的 Spring cloud demo项目

###项目架构

### spring cloud config 简介

用于集中管理项目配置(可以基于不同的版本)，当项目启动的时候从config server 上拉取配置  
bootstrap.yml 的优先级低于 application.yml  
如果配置了spring.cloud.config.allowOverride=true，bootstrap 的属性被会被远程config server中的属性值替换  

#### 服务端配置

下面是一个简单的git地址配置，复杂的配置可以通过官网查看，比如实现不同团队项目分离等

```
spring:
  cloud:
    config:
      server:
        git:
          uri: https://github.com/spring-cloud-samples/config-repo
          username: trolley
          password: strongpassword


```

#### 客户端配置
客户端通过 name，profile，label 来决定读取服务端的哪一个配置属性

比如 foo-dev.yml

```
spring:
  application:
    name: foo
  profiles:
    active: dev,mysql

```

### spring cloud bus

spring cloud config 只能在项目启动时拉取配置，spring cloud bus可以通过mq实现动态修改配置，配合Spring cloud config

依赖：rabbitmq   （需要自己安装）
http://localhost:15672

配置的动态刷新可以通过两种方式，定时从服务器pull，或者监听服务端的push

spring cloud bus，就是通过mq向客户端push消息的方式来实现的。

### web hook 到localhost
https://ngrok.com/