package com.Clinicia.Clinica.infra.springdoc;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfiguration {

    public OpenAPI customOpenApi(){
        return new OpenAPI().info(new Info()
                .title("Clinina")
                .description("api reste clinica")
                .contact(new Contact().name("backend")).license(new License().name("apache 2.0").url("http://clinica/api/licenca")));

    }
}
