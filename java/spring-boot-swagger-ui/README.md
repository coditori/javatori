# Spring Boot RESTful API with Swagger UI

It's better to keep all layers seperated form each other. This is a multi-module Maven project that seperated Data Access and Service Layers from Web Layer. You just need to add you Database dependencies and configurations to Web Layer and put your Repository and Business Logic methods in [spring-dans](https://github.com/massoudAfrashteh/code-examples/blob/master/java/spring-dans).

**How to use**
Just import project then you IDE will automatically import dependencies like [spring-dans](https://github.com/massoudAfrashteh/code-examples/blob/master/java/spring-dans). After that run Spring Boot which is located in [Application Class](https://github.com/massoudAfrashteh/code-examples/blob/master/java/spring-boot-swagger-ui/restful-api/src/main/java/starter/Application.java) and then open http://localhost:8080/swagger-ui.html to see the RESTful API Documentation page.