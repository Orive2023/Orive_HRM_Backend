package com.orive.project.Configruration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfigruration {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
