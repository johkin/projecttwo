package se.acrend.microservice.projecttwo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
class OpenApiConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info().title("Project Two")
                        .version("0.0.1"))
            .servers(Collections.singletonList(
                new Server().description("Local server")
                        .url("http://localhost:8080/track-api")));
    }


}
