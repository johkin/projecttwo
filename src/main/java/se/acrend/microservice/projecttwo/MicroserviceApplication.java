package se.acrend.microservice.projecttwo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import se.acrend.microservice.projecttwo.config.ApplicationConfig;
import se.acrend.microservice.projecttwo.config.SwaggerConfig;
import se.acrend.microservice.projecttwo.config.WebSocketConfig;

import javax.sql.DataSource;

@SpringBootApplication
@Import({ApplicationConfig.class, SwaggerConfig.class, WebSocketConfig.class})
public class MicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceApplication.class, args);


	}
}
