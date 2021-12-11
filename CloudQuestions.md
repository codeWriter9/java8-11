# Cloud Interview Questions
New Features Of Java 8 - Java 11 and other Interview Questions


### What is the difference between API Gateway and Service Discovery ?
* API Gateway - we have to register services with its URL and matching patterns like this
```
id: your-cloud-service
    uri: http://localhost:9003/
    predicates:
      - Path=/cloud/service/**
```
But the problem here is we can have multiple instances on different ports for the same service. Like this
```
uri: http://localhost:9003/
uri: http://localhost:9004/
uri: http://localhost:9005/
```
In this case, a gateway will fail to route to other instances
* Service Discovery - In case of service discovery, we will have to register client services to service discovery (which is another service). Like this
```
 eureka:
  client:
    register-with-eureka: true
    fetch-registry: true
    service-url:
     defaultZone: http://localhost:8761/eureka/
```

