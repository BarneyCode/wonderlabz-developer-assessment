package com.barney.wonderlabzdeveloperassessmentcore.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Project Name: wonderlabz-developer-assessment-core
 * Developer   : bkatakwa
 * Date        : 22/4/2021
 * Time        : 21:21
 */
@Configuration
@EnableSwagger2
public class ApiDocumentation {
    @Bean
    public Docket apiDocumentationBean() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.barney.wonderlabzdeveloperassessmentcore.controllers"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(new ApiInfoBuilder()
                        .version("1.0")
                        .title("Barnabas Katakwa Documentation")
                        .contact(new Contact("Barnabas Katakwa", "https://www.barneykatakwa.co.zw",
                                "barneykatakwa@gmail.com"))
                        .description("Documentation for Wonderlabz Assessment")
                        .build());
    }
}
