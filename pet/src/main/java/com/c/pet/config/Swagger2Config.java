package com.c.pet.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration   //被我们的springboot进行扫描
@EnableSwagger2  //开启swagger
public class Swagger2Config {
    @Bean
    public Docket createRestApi(){
        return  new Docket(DocumentationType.SWAGGER_2)  //创建一个swagger文档
                .apiInfo(apiInfo())                     //调用下面那个函数
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.c.pet.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    //apiInfo指接口文档信息
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("宠物医院预约平台api")
                .description("宠物医院预约平台")
                .contact(new Contact("仙女","","1334120831@qq.com"))
                .termsOfServiceUrl("http://localhost:8080")
                .version("1.0")
                .build();
    }


}
