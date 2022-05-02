package com.system.systemsola.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;


@Configuration
public class OpenAPIConfig {
    
//	private final static String  BASE_PACKAGE = "com.system.systemsola";
	private final static String  TITLE = "API System solar";
	private final static String  DESCRIPTION = "API de gerenciamento e consulta do sistema solar";
	private final static String  NAME_AUTHOR = "Mário Junior";
	private final static String  VERSION = "1.0.0";
	private final static String  LICENCA = "Apache 2.0";
	private final static String  LINCENS_ADDRESS = "http://springdoc.org";
	private final static String  GITHUB = "https://github.com/Mario23junior";
	private final static String  EMAIL_API = "mariojunior3251@gmail.com";
	
	
	  @Bean
	  public OpenAPI springShopOpenAPI() {
	      return new OpenAPI()
	              .info(new Info().title(TITLE)
	              .description(DESCRIPTION)
	              .version(VERSION)
                  .contact(new Contact().email(EMAIL_API).name(NAME_AUTHOR))
 	              .license(new License().name(LICENCA).url(LINCENS_ADDRESS)))
	              .externalDocs(new ExternalDocumentation()
	              .description(DESCRIPTION)
	              .url(GITHUB));
	  }	
   

	
}
