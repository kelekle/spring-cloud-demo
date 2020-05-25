### Spring-Cloud-Demo 
1. 搭建一个空的spring-cloud项目
2. 创建一个eureka-server用来提供服务注册和发现，部署在本地8761端口
3. 创建producer1和producer2两个生产者(application.name=producer-service)，用来提供两个相同服务(主要是为了测试负载均衡)，并向注册中心注册，分别部署在本地8762和8763端口
4. 创建consumer(使用openfegin)(application.name=consumer-service)，通过@FeignClient调用producer-service,配置文件添加了负载均衡相关配置，同时增加熔断功能，服务不可用时调用MyServiceFallback,开启断路器：Hystrix 仪表盘（本地访问地址：http://localhost:8765/hystrix），向注册中心注册，部署在本地8765端口
5. 创建zuul项目，在配置中将/api/v1/**映射到consumer-service上，添加filter，没有携带token时返回: token is empty，并向注册中心注册，部署在本地8769端口
6. 创建config-server项目，用来从git上(即本仓库的spring-cloud-config文件夹)获取相关配置，向注册中心注册,部署在8888端口
7. 创建config-client项目，从config-server获取config-client-dev.properties配置，向注册中心注册, 访问http：//localhost:8768/(getProjectName/getVersion/getAuthor)调用相对应的serviceId即可返回相应信息
  
一共设计了两个测试接口:
1. http://localhost:8769/api/v1/demo/get 返回数据库中的所有学生
2. http://localhost:8769/api/v1/test/get 用来测试负载均衡，因为采用轮询规则，所有连续访问两次将返回不同端口信息