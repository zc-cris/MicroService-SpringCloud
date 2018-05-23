# MicroService-SpringCloud
## 关于初入SpringCloud 坑的一个实现案例，从零搭建到完成

#### 1. 环境准备：
  Eclipse:Oxygen.3 Release (4.7.3)<br>
  Maven: 3.5.0<br>
  Java: 1.8.0_162<br>
  Mysql: 5.7.11<br>
  Git: 2.15.0.windows.1<br>
  GitHub
  
#### 2. 主要依赖
  Mybatis + druid + Lombok(模板代码自动生成插件) + SpringCloud（Eureka，Ribbon，Feign，Hystrix，Zuul，Config）+SpringBoot
  
### 案例目的：
  主要是为了学习SpringCloud，一步一步搭建起来一个微服务的架构，熟悉SpringCloud 家族中的五大神兽，先上手混个脸熟，然后再琢磨，
  搭建过程中还是遇上了一些坑的，但是都总结在了案例文档里，如果感兴趣的同学可以参考，目前SpringCloud 还不是很广为人知，感兴趣的
  同学可以加入SpringCloud 的中国社区：http://springcloud.cn/
  
### 案例总结：
  通过简单的整合案例上手，发现作为微服务架构的一站式解决方案，SpringCloud 以完善，简洁，强大的融合能力，会在今后的微服务开发中大放异彩；
  目前Spring 官网已经把 Spring Boot+Spring Cloud+Spring Cloud Data Flow 放在了首页：https://spring.io/   <br>
  构建 + 融合 + 连接 的"三叉戟"，个人觉得会开启java
  企业级开发的未来新架构体系，共勉！
  
### 案例整合流程
  1. 构建整体模块（父工程+公共模块+消费模块+生产模块）
  2. 构建Eureka 模块及集群（重点）
  3. 集成Ribbon 组件
  4. 集成Feign 组件（重点）
  5. 集成Hystrix 组件并上手HystrixDashBoard（重点）
  6. 集成Zuul 组件
  7. 集成Config 组件
  
### 个人建议
   该案例作为初入SpringCloud 坑的同学可能比较友好，因为提供了完整的构建流程文档，并且注释也是比较详细，如果有微服务开发经验的同学非常快就
   可以理解。如果是大牛，欢迎指出错误
   

  
  
  

