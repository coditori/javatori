package restful.config;

import java.util.Arrays;

import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.swagger.Swagger2Feature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import restful.controller.ExceptionHandler;
import restful.controller.UserRestfulController;

@Configuration
@EnableAutoConfiguration
@EnableTransactionManagement
@ComponentScan(basePackages = "restful")
public class AppConfig {
	@Autowired
	private Bus bus;

	@Autowired
	private UserRestfulController userRestService;

	@Bean
	public Server rsServer() {
		final JAXRSServerFactoryBean endpoint = new JAXRSServerFactoryBean();
		endpoint.setProvider(new JacksonJsonProvider());
		endpoint.setBus(bus);
		endpoint.setAddress("/");
		endpoint.setServiceBeans(Arrays.<Object>asList(userRestService));
		endpoint.setFeatures(Arrays.asList(new Swagger2Feature()));
		endpoint.setProvider(getExceptionHandler());
		return endpoint.create();
	}

	@Bean
	public ExceptionHandler getExceptionHandler() {
		return new ExceptionHandler();
	}

	// @Bean
	// public SampleServiceREST getSampleServiceRestClient() {
	// final List providers = new ArrayList();
	// providers.add(getJacksonJsonProvider());
	// providers.add(getExceptionHandler());
	// return JAXRSClientFactory.create("http://localhost:8090/services/rest", SampleServiceREST.class, providers);
	// }

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