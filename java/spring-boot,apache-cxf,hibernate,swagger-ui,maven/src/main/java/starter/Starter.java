package starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import restful.config.AppConfig;

@SpringBootApplication
public class Starter {
	public static void main(final String[] args) {
		SpringApplication.run(AppConfig.class, args);
	}
}