# spring-boot-cxf-jaxrs-hibarnate-maven-swagger-ui

First download the dependencies with Maven's POM file then just change your Database connection's configuration and save below contents on src/main/resources/persistence-mysql.properties
```java
# jdbc.X
jdbc.driverClassName=com.mysql.cj.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/spring_restful_best_practice?createDatabaseIfNotExist=true
jdbc.username=yourDBusername
jdbc.password=yourDBpassword

# hibernate.X
hibernate.dialect=org.hibernate.dialect.MySQL5Dialect
hibernate.show_sql=false
hibernate.hbm2ddl.auto=update
```

The last thing is run it with your IDE or try out with __mvn spring-boot:run. If your Application Is running on PORT 8080 just open **http://localhost:8080/services/services** then you will see your API links and click the Swagger Link.

The [Full Tutorial of Spring and CXf](http://code.massoudafrashteh.com/spring-boot-cxf-jaxrs-hibernate-maven-swagger-ui) is available on my Website :)
