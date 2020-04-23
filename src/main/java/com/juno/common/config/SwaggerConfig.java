package com.juno.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Value("${swagger.base.url}")
	private String baseUrl;

	@Bean
	public Docket api() {
		String version = "v1";
		String title = "API 시스템 Version 1";

		return new Docket(DocumentationType.SWAGGER_2)
				.consumes(getConsumeContentTypes())
				.produces(getProduceContentTypes())
				.globalOperationParameters(getHeaderParam())
				.groupName(version)
				.select()
				.apis(RequestHandlerSelectors.any()) // 현재 RequestMapping으로 할당된 모든 URL 리스트를 추출
				.paths(PathSelectors.ant("/api/v1/**")) // 그중 /api/** 인 URL들만 필터링
				.build()
				.apiInfo(apiInfo(title, version));
	}

	private List<Parameter> getHeaderParam() {
		return List.of(
				getAuthorization()
		);
	}

	private Parameter getAuthorization() {
		ParameterBuilder parameterBuilder = new ParameterBuilder();
		parameterBuilder.name(HttpHeaders.AUTHORIZATION) //헤더 이름
				.description("Access Tocken") //설명
				.modelRef(new ModelRef("string"))
				.parameterType("header")
				.required(true)
				.build();

		return parameterBuilder.build();
	}

	private ApiInfo apiInfo(String title, String version) {
		return new ApiInfo(
				title,
				"API Docs",
				version,
				baseUrl,
				new Contact("Contact Me", baseUrl, "sosdig@naver.com"),
				"Licenses",
				baseUrl,
				new ArrayList<>());
	}

	private Set<String> getConsumeContentTypes() {
		Set<String> consumes = new HashSet<>();
		consumes.add("application/json;charset=UTF-8");
		consumes.add("application/x-www-form-urlencoded");
		return consumes;
	}

	private Set<String> getProduceContentTypes() {
		Set<String> produces = new HashSet<>();
		produces.add("application/json;charset=UTF-8");
		return produces;
	}
}
