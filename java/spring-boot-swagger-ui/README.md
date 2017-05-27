# Spring Boot RESTful API with Swagger UI

It's better to keep all layers seperated form each other. This is a multi-module Maven project that seperated Data Access and Service Layers from Web Layer. You just need to add you Database dependencies and configurations to Web Layer and put your Repository and Business Logic methods in [spring-dans](https://github.com/massoudAfrashteh/code-examples/blob/master/java/spring-dans).

#### How to use
Just import project then your IDE will automatically import dependencies like [spring-dans](https://github.com/massoudAfrashteh/code-examples/blob/master/java/spring-dans).



#### How to run
Now run Spring Boot which is located in [Application Class](https://github.com/massoudAfrashteh/code-examples/blob/master/java/spring-boot-swagger-ui/restful-api/src/main/java/starter/Application.java) and then open below links:

**Checking api:** open http://localhost:8080/ping (or send a GET request) then you should get **pong** in the response.
<br>**Swagger UI:** open http://localhost:8080/swagger-ui.html to see the Spring Boot RESTful API Documentation page.

![Swagger UI main page](/doc/images/spring-boot-swagger-ui.png)