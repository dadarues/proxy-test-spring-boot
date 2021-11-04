package com.leantech.proxytest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.leantech.proxytest.SimpleFilter;

@Configuration
public class SimpleFilterConfig {

	@Bean
	public SimpleFilter simpleFilter() {
		return new SimpleFilter();
	}
	
}
