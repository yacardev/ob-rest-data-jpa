package com.example.obrestdatajpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

/***
 * Swagger configuration
 */
@Configuration
public class SwaggerConfig {
    @Bean
    public InternalResourceViewResolver defaultViewResolver() {
        return new InternalResourceViewResolver();
    }
     @Bean
     public Docket api(){
         return new Docket (DocumentationType.SWAGGER_2)
                 .apiInfo(apiDetails())
                 .select()
                 .apis(RequestHandlerSelectors.any())
                 .paths(PathSelectors.any())
                 .build();
     }

     private ApiInfo apiDetails(){
         return new ApiInfo("Spring boot Books API Rest",
                 "Library API rest docs",
                 "1.0",
                 "https://www.google.com",
                 new Contact("Matias","https://www.google.com","matiasexelujan@gmail.com"),
                 "MIT",
                 "https://www.google.com",
                 Collections.emptyList());
     }
}
