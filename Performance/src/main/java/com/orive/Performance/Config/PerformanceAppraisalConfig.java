package com.orive.Performance.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PerformanceAppraisalConfig {
	
	@Bean	
	public ModelMapper modelMapper(){
		
		return new ModelMapper();
	}

}
