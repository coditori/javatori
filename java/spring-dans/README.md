# Spring DANS (Data Access and Service Layer)

It's better to keep all layers separated form each other, in my case I put Business Logic (Service) Layer and Data Access Layer both in a Maven Module and used in other examples.

There is no dependency for Database here because we don't need Database even for Tests we can use Mockito. Just add Database dependencies and configurations to Web Layer. E.g [spring-boot, swagger-ui](https://github.com/massoudAfrashteh/code-examples/blob/master/java/spring-boot-swagger-ui) is a Web multi-module project that used spring-dans.

#### Compilation
This project will not compile alone! why? because needs a main module "com.massoudafrashteh.code.spring" inside it's POM file. 
<pre>
  &lt;parent&gt;
    &lt;groupId&gt;com.massoudafrashteh.code.spring&lt;/groupId&gt;
    &lt;artifactId&gt;spring-root&lt;/artifactId&gt;
    &lt;version&gt;0.0.1&lt;/version&gt;
  &lt;/parent&gt;
</pre>

Now you know about the hierarchy and just read next part [how to use](https://github.com/massoudAfrashteh/code-examples/tree/master/java/spring-dans#how-to-use).

#### How to use
I created a symlink to spring-dans module in any multi-module project that I needed dans. After clone the repository just import [spring-boot-cxf](https://github.com/massoudAfrashteh/code-examples/tree/master/java/spring-boot-cxf) or [spring-boot-restful](https://github.com/massoudAfrashteh/code-examples/tree/master/java/spring-boot-restful) inside your IDE then it will automatically import dans, That's it!