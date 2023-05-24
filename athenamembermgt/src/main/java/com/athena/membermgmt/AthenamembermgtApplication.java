package com.athena.membermgmt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.athena.membermgmt.interceptor.HttpRequestResponseLoggingInterceptor;

@SpringBootApplication
public class AthenamembermgtApplication implements WebMvcConfigurer {
	@Autowired
	private HttpRequestResponseLoggingInterceptor loggingInterceptor;

	public static void main(String[] args) {
		SpringApplication.run(AthenamembermgtApplication.class, args);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loggingInterceptor);
	}

}
