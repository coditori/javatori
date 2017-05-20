# Springol is an example based on __Java Spring Technologies__: __Spring MVC__, __Spring JPA__, and __Spring security__ + __Hibernate__ behind the scenes.
 
Use Maven to download the dependencies. It uses springol.sql to create tables but before that make sure that you've created __springol__ db. It's time to change your db connection and save below contents here src/main/resources/database.properties
```java
database.driverClassName = com.mysql.cj.jdbc.Driver
database.url = jdbc:mysql://localhost:3306/springol?createDatabaseIfNotExist=true
database.username = root
database.password = yourDBPass

hibernate.dialect = org.hibernate.dialect.MySQLDialect
hibernate.hbm2ddl.auto = update
hibernate.show_sql = true 
```

Then if your application is listening on port 8080 open __http://localhost:8080/Springol/admin__ although the default username & password are admin