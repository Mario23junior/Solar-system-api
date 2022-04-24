package com.system.systemsola.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class configModelMapper {
  
	@Bean
	public ModelMapper mapper() {
		return new ModelMapper();
		
 	}
}
