package com.orive.Organisation.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrganisationConfiguration {

	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}
}
