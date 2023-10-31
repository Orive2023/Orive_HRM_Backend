package com.orive.Training.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class TrainersListConfiguration {
	
	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}


}
