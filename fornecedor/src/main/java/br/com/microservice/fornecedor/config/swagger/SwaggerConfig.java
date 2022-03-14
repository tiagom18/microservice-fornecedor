package br.com.microservice.fornecedor.config.swagger;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {


	@Bean
	public GroupedOpenApi publicApi() {
	      return GroupedOpenApi.builder()
	              .group("fornecedor")
	              .pathsToMatch("/**")
	              .build();
	  }


	@Bean
	  public OpenAPI springShopOpenAPI() {
	      return new OpenAPI()
	              .info(new Info().title("fornecedor")
	              .description("Uma documentação feita para o teste de produto, fornecedor e pedido"));
	              
	             
	  }
}