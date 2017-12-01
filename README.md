###这是一个简单的 Spring cloud demo项目

###项目架构

### spring cloud config 简介
用于集中管理项目配置(可以基于不同的版本)，当项目启动的时候从config server 上拉取配置  
bootstrap.yml 的优先级低于 application.yml  
如果配置了spring.cloud.config.allowOverride=true，bootstrap 的属性被会被远程config server中的属性值替换  


### spring cloud bus

spring cloud config 只能在项目启动时拉取配置，spring cloud bus可以通过mq实现动态修改配置，配合Spring cloud config

依赖：rabiitmq   
http://localhost:15672




### web hook 到localhost
https://ngrok.com/