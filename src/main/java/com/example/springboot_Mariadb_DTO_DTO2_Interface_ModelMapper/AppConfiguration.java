package com.example.springboot_Mariadb_DTO_DTO2_Interface_ModelMapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration 
{

	@Bean
	public ModelMapper modelmapper()
	{
		return new ModelMapper();
	}
}
