package com.blog.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI apiConfig() {
        return new OpenAPI()
                .info(new Info()
                        .title("Blogging Website")
                        .description("Swagger Configuration")
                        .version("0.0.0")
                        .contact(new Contact()
                                .name("Blog Web")
                                .email("Blog@gmail.com")))
                .externalDocs(new ExternalDocumentation()
                        .description("Blog Documentation")
                        .url("https://www.google.com"));
    }
}
