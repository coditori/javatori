# Spring Boot RESTful API with Swagger UI

It's better to keep all layers seperated form each other. This is a multi-module Maven project that seperated Data Access and Service Layers from Web Layer. You just need to add your Database dependencies and configurations to Web Layer and put your Repository and Business Logic methods in [spring-dans](https://github.com/massoudAfrashteh/code-examples/blob/master/java/spring-dans). 

In this example I just used MySQL Database and Spring Boot will configure it via application.properties, but you can use any Database that you need.

#### Spring Rest or JAX-RS?
I prefer JAX-RS with an integration of spring-boot for more information see the [when to use column](https://github.com/massoudAfrashteh/code-examples)

#### How to use
Just import project then your IDE will automatically import dependencies like [spring-dans](https://github.com/massoudAfrashteh/code-examples/blob/master/java/spring-dans).

#### How to run
Now run Spring Boot which is located in [Application Class](https://github.com/massoudAfrashteh/code-examples/blob/master/java/spring-boot-restful/restful/src/main/java/starter/Starter.java) and then open below links:

**Checking api:** open http://localhost:8080/ping (or send a GET request) then you should get **pong** in the response.
<br>**Swagger UI:** open http://localhost:8080/swagger-ui.html to see the Spring Boot RESTful API Documentation page.

![Swagger UI main page](https://raw.githubusercontent.com/massoudAfrashteh/code-examples/master/java/spring-boot-restful/doc/images/spring-boot-swagger-ui.png)