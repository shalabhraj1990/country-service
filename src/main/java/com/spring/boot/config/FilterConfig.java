package com.spring.boot.config;

import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.boot.country.filter.AnalyticFilter;
import com.spring.boot.country.filter.RequestAndResponseFilter;

@Configuration
public class FilterConfig {
	@Autowired
	AnalyticFilter analyticFilter;
	@Autowired
	RequestAndResponseFilter requestAndResponseFilter;
	
	@Bean
	public FilterRegistrationBean<Filter> registeFilter(){
		FilterRegistrationBean<Filter> registration = new FilterRegistrationBean<>();
		registration.setFilter(analyticFilter);
		registration.setFilter(requestAndResponseFilter);
		registration.addUrlPatterns("/*");
		return registration;
	}

}
