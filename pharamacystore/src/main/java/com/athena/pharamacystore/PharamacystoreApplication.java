package com.athena.pharamacystore;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.athena.pharamacystore.dto.DrugInfo;
import com.athena.pharamacystore.invoker.DrugApiInvokerService;

@SpringBootApplication
@EnableDiscoveryClient
public class PharamacystoreApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(PharamacystoreApplication.class, args);
		DrugApiInvokerService drugApiInvokerService = context.getBean(DrugApiInvokerService.class);

//		List<ServiceInstance> serviceInstances = drugApiInvokerService.showPharamacyServiceInstances();
//		serviceInstances.stream().forEach(instance -> {
//			System.out.println(instance.getScheme() + "//" + instance.getHost() + ":" + instance.getPort());
//		});
		for (int i = 0; i < 1; i++) {
			List<DrugInfo> drugs = drugApiInvokerService.searchDrugsThroughLoadbalancer("dolo");
			drugs.stream().forEach(System.out::println);
		}
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
