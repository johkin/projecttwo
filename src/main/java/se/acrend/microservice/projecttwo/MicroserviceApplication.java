package se.acrend.microservice.projecttwo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import se.acrend.microservice.projecttwo.config.ApplicationConfig;
import se.acrend.microservice.projecttwo.config.WebSocketConfig;

@SpringBootApplication
public class MicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceApplication.class, args);


	}
}
