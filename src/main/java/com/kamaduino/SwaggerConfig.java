package com.kamaduino;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;
//
//import java.util.function.Predicate;
//
//import static springfox.documentation.builders.PathSelectors.regex;
//
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    /*public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
                .apiInfo(apiInfo()).select().paths(postPaths()).build();
    }

    private Predicate<String> postPaths() {
        return or(regex("/api/*"), regex("/api/javainuse.*"));
    }*/
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.kamaduino.controller"))
//                .paths(PathSelectors.ant("/api/*"))
                .paths(postPaths())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Kamaduino API")
                .description("Kamaduino API")
                //.termsOfServiceUrl("http://javainuse.com")
                .contact("jcaso26@hotmail.com").license("J.Caso License")
                .licenseUrl("jcaso26@hotmail.com").version("1.0").build();
    }

    private Predicate<String> postPaths() {
        return or(
                regex("/api.*")
//                regex("/api/comments.*")
        );
    }

}