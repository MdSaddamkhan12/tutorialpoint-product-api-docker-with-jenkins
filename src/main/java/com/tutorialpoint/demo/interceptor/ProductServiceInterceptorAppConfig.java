package com.tutorialpoint.demo.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ProductServiceInterceptorAppConfig implements WebMvcConfigurer{

	@Autowired
	ProductServiceInterceptor productServiceInterceptor;
	
	public void addInterceptor(InterceptorRegistry registry) {
		registry.addInterceptor(productServiceInterceptor);
	}
}
