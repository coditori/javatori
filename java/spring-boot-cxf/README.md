# Spring Boot integration with Apache CXF under JAX-RS and Swagger UI

It's better to keep all layers separated form each other. This is a multi-module Maven project that seperated Data Access and Service Layers from Web Layer. You just need to add your Database dependencies and configurations to Web Layer and put your Repository and Business Logic methods in [spring-dans](https://github.com/massoudAfrashteh/code-examples/blob/master/java/spring-dans). 

In this example I just used MySQL Database and Spring Boot will configure it via application.properties, but you can use any Database that you need.

#### Compilation
This project will not compile alone! why? because this is a needs dans module inside it's POM file.
'''xml    
<!-- spring dependencies -->
<dependency>
  <groupId>com.massoudafrashteh.code.spring.dans</groupId>
  <artifactId>spring-dans</artifactId>
  <version>${spring-dans.version}</version>
</dependency>
'''

Now you know about the hierarchy and just read next part [how to use](https://github.com/massoudAfrashteh/code-examples/tree/master/java/spring-boot-restful#how-to-use).

#### How to use
Just import project then your IDE will automatically import dependencies like [spring-dans](https://github.com/massoudAfrashteh/code-examples/blob/master/java/spring-dans).

#### How to run
Now run Spring Boot which is located in [Application Class](https://github.com/massoudAfrashteh/code-examples/blob/master/java/spring-boot-cxf/restful/src/main/java/starter/Starter.java) and then open below links:

**Checking api:** open http://localhost:8080/services/ping (or send a GET request) then you should get **pong** in the response.
<br>**Swagger UI:** open http://localhost:8080/services/services to see the Spring Boot RESTful API Documentation link.

![Swagger UI main page](https://raw.githubusercontent.com/massoudAfrashteh/code-examples/master/java/spring-boot-cxf/doc/images/spring-boot-cxf-swagger-ui.png)