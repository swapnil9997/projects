package com.yashoda.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.yashoda.dto.PolicyInfo;
import com.yashoda.exception.PolicyNotFoundException;
import com.yashoda.feign.config.FeignConfig;

@FeignClient(name = "INSURANCE-SERVICE", configuration = { FeignConfig.class })
public interface PolicyService {
	@GetMapping(value = "/policy/{policyNo}/details", consumes = { MediaType.APPLICATION_JSON_VALUE })
	PolicyInfo getPolicy(@PathVariable("policyNo") int policyNo) throws PolicyNotFoundException;
}
