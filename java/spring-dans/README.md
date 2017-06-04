# Spring DANS (Data Access and Service Layer)

It's better to keep all layers separated form each other, in my case I put Business Logic (Service) Layer and Data Access Layer both in a Maven Module and used in other examples.

There is no dependency for Database here because we don't need Database even for Tests we can use Mockito. Just add Database dependencies and configurations to Web Layer. E.g [spring-boot, swagger-ui](https://github.com/massoudAfrashteh/code-examples/blob/master/java/spring-boot-swagger-ui) is a Web multi-module project that used spring-dans.

**How to use**
I Created a symlink to spring-dans module in any multi-module project that I needed dans. That means when you import a project like [spring-boot, swagger-ui](https://github.com/massoudAfrashteh/code-examples/blob/master/java/spring-boot-swagger-ui) in your JEE IDE it will automatically import dans, That's it!