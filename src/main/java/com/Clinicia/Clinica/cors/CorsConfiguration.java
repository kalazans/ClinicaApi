package com.Clinicia.Clinica.cors;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("localhost/8080","http://localhost:8080/swagger-ui/index.html")
                .allowedMethods("PUT","GET","POST","DELETE","OPTIONS","HEADER");
    }
}
