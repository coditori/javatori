package starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Starter {

	public static void main(final String[] args) {
		SpringApplication.run(CxfConfig.class, args);
	}
}