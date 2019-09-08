package com.qianshu.kindergarten.config;

import com.google.common.base.Predicate;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        Predicate<RequestHandler> predicate = input -> {
            Class<?> declaringClass = input.declaringClass();
            if (declaringClass == BasicErrorController.class)// 排除
                return false;
            if(declaringClass.isAnnotationPresent(RestController.class)) // 被注解的类
                return true;
            if(input.isAnnotatedWith(ResponseBody.class)) // 被注解的方法
                return true;
            return false;
        };
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select().apis(predicate)
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 文档标题
                .title("Spring Boot中使用Swagger2构建RESTful APIs")
                // 文档描述
                .description("http://www.tianyigps.com")
                .termsOfServiceUrl("http://localhost:8080")
                .version("version 2.0.0")
                .contact(contact())
                .build();
    }

    private Contact contact() {
        return new Contact("@于龘龘", "http://www.baidu.com", "15194502006@163.com");
    }
}
