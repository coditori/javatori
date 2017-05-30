package starter;

import java.util.Arrays;

import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.swagger.Swagger2Feature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.massoudafrashteh.code.restful.controller.IndexController;
import com.massoudafrashteh.code.restful.controller.UserController;
import com.massoudafrashteh.code.restful.exception.ExceptionHandler;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com")
@EntityScan(basePackages = "com.massoudafrashteh.code.spring.dans.domain")
@EnableJpaRepositories(basePackages = "com.massoudafrashteh.code.spring.dans.repository")
public class CxfConfig {

	@Autowired
	private Bus bus;

	@Bean
	public Server rsServer() {
		final JAXRSServerFactoryBean endpoint = new JAXRSServerFactoryBean();
		endpoint.setProvider(new JacksonJsonProvider());
		endpoint.setProvider(getExceptionHandler());
		endpoint.setBus(bus);
		endpoint.setAddress("/");
		endpoint.setServiceBeans(Arrays.<Object>asList(indexController(), userController()));
		endpoint.setFeatures(Arrays.asList(new Swagger2Feature()));
		return endpoint.create();
	}

	@Bean
	public ExceptionHandler getExceptionHandler() {
		return new ExceptionHandler();
	}

	@Bean
	public IndexController indexController() {
		return new IndexController();
	}

	@Bean
	public UserController userController() {
		return new UserController();
	}

	// The default address of CXF RESTfull API is /services to change the API
	// sub-directory from /services with /api or anything that you like
	// @Bean
	// public ServletRegistrationBean cxfServlet() {
	// final ServletRegistrationBean servletRegistrationBean =
	// new ServletRegistrationBean(new CXFServlet(), "/api/*");
	// servletRegistrationBean.setLoadOnStartup(1);
	// return servletRegistrationBean;
	// }
}
