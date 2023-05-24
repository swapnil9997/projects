package com.yashoda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;

import com.yashoda.dto.PolicyInfo;
import com.yashoda.service.PolicyService;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class YashodafeignApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(YashodafeignApplication.class, args);
		PolicyService policyService = context.getBean(PolicyService.class);

		PolicyInfo policyInfo = policyService.getPolicy(2);
		System.out.println(policyInfo);
	}
}
