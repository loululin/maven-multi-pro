package com.lulin.demo.comm.swagger2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <p>Title: SwaggerConfig </p>
 * <p>Description: TODO </p>
 * Date: 2018年3月14日 下午2:19:48
 * @author hp@hiynn.com
 * @version 1.0 </p> 
 * Significant Modify：
 * Date               Author           Content
 * ==========================================================
 * 2018年3月14日         hp         创建文件,实现基本功能
 * 
 * ==========================================================
 */
@Configuration
@EnableWebMvc
@EnableSwagger2
@ComponentScan(basePackages = {"com.lulin.demo.controller"})
public class SwaggerConfig {
	
	
	@Bean
    public Docket createDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("admin")
                .select()
                .paths(PathSelectors.any())
                .build();
    }
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Project RESTful APIs")
				.description("project api document")
   			    .contact(new Contact("loulvlin", "", "loulvlin@hiynn.com"))
   			    .termsOfServiceUrl("http://localhost:8081")
   			    .version("1.0")
   			    .build();
	}

}
