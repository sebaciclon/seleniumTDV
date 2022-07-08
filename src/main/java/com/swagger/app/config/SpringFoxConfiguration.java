package com.swagger.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringFoxConfiguration {

	@Bean
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.swagger.app.controller"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(metainfo());
	}

	@SuppressWarnings("deprecation")
	private ApiInfo metainfo() {
		ApiInfo ai = new ApiInfo(
				"TP TDV sobre Swagger",
				"Realizado por Sebastian Esains y Leonardo Esains", 
				"1.0", 
				"terminos de servicios",
				"contacto: sebaesains77@gmail.com",
				"Apache License Version 2.0", 
				"http://www.apache.org");
		return ai;
	}

	
}
