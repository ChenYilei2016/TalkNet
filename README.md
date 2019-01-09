# TalkNet
 除了乐优商城的相关技术
 主要是 分布式配置中心的实现 以及 spring cloud bus 的结合
---
准备写入 1. spring cloud stream 结合 MQ 或 kafka 的消息发送与接收
2. spring cloud sleuth 监控服务的链路 原生基于HTTP ( 后可结合stream mq 或 kafka )


1、基于bootstrap的前端页面使用RESTful的url异步请求后台得到数据。
2、后台基于springcloud Finchley的技术栈并分成了多个微服务，使用eureka作为分布式注册中心。
3、在用户注册上使用rabbitMq接收消息并基于阿里大于的接口实现发送短信的用户注册功能。
4、在登陆上使用基于token的RSA双向加密验证身份节约了服务器的资源。
5、在博客的数据存储上使用spring data jpa 配合 redis、mongodb和elasticsearch实现相关数据的缓存和搜索。使用mybatis整合通用mapper进行主要的数据存储。
6、在微服务的调用上使用springcloud的Feign进行restful的Http调用。
7、配置spring cloud zuul网关，可以进行负载均衡，可以进行请求的过滤。
8、在各个微服务的配置上使用spring cloud config分布式配置中心基于Github进行统一的管理。

