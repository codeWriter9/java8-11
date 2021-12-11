# Cloud Interview Questions
New Features Of Java 8 - Java 11 and other Interview Questions


### 1. What is the difference between API Gateway and Service Discovery ?
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

### 2. What is Ingress ? Why do we need this ?
Ingress is a Kubernetes API object which facilitates HTTP and HTTPS routing from outside cluster to within cluster. Ingress is needed to expose services over HTTP(S)
Ingress can also be defined as a level 7 (Application Level) load balancer
