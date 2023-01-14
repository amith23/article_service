package com.amith.article_service;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.amith.article_service.interceptors.RequestHeaderValidationInterceptor;

@Configuration
public class Config implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new RequestHeaderValidationInterceptor());

	}
}