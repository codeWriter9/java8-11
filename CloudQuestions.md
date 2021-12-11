# Cloud Interview Questions
New Features Of Java 8 - Java 11 and other Interview Questions


#### 1. What is the difference between API Gateway and Service Discovery ?
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

#### 2. What is Ingress ? Why do we need this ?
Ingress is a Kubernetes API object which facilitates HTTP and HTTPS routing from outside cluster to within cluster. Ingress is needed to expose services over HTTP(S).
Ingress can also be defined as a level 7 (Application Level) load balancer

#### 3. What is difference between Layer 4 and Layer 7 Load balancer ?
Layer 4 load balancer operates at the transport layer of the [OSI model](https://en.wikipedia.org/wiki/OSI_model) 
It has the following pros
* Suitable for packet-level balancing of loads
* It is quick and efficient because it does not take data into account
* Because packets are not examined, they are more secure. If it is compromised, no one will be able to access the data
* It just forwards the packets. It does not need to decrypt the content before forwarding
* Maintains only one NATed connection between the client and the server, allowing your load balancer to serve a maximum number of TCP connections
and following cons
* Based on the content, smart load balancing is not possible
* Because it is a stateful protocol, it must be sticky. When a connection is established, it is routed to a single server in the backend. All packets sent through this connection are routed to a single server. Based on the algorithm, the next connection will select another server

Layer 7 load balancer operates at the application layer of the of the [OSI model](https://en.wikipedia.org/wiki/OSI_model) 
It has the following pros 
* Based on the URL, it provides smart routing
* Caching
and following cons
* Expensive
* Decryption is required

