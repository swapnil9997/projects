package com.yashoda.feign.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.yashoda.decoders.InsuranceErrorDecoder;

@Configuration
public class FeignConfig {

	@Bean
	public InsuranceErrorDecoder insuranceErrorDecoder() {
		return new InsuranceErrorDecoder();
	}

}
