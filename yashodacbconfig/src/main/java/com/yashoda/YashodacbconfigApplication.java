package com.yashoda;

import java.time.Duration;
import java.util.function.Consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.yashoda.dto.PolicyInfo;
import com.yashoda.service.PolicyService;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;

@SpringBootApplication
@EnableDiscoveryClient
public class YashodacbconfigApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(YashodacbconfigApplication.class, args);
		PolicyService policyService = context.getBean(PolicyService.class);
		for (int i = 0; i < 10; i++) {
			try {
				PolicyInfo policyInfo = policyService.getPolicy(1);
				System.out.println(policyInfo);
			} catch (Throwable t) {
				t.printStackTrace();
			}
		}
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

//	@Bean
//	public Customizer<Resilience4JCircuitBreakerFactory> customizeCircuitBreakerFactory() {
//		return new Customizer<Resilience4JCircuitBreakerFactory>() {
//			@Override
//			public void customize(Resilience4JCircuitBreakerFactory tocustomize) {
//				tocustomize.configure(new Consumer<Resilience4JConfigBuilder>() {
//					@Override
//					public void accept(Resilience4JConfigBuilder builder) {
//						builder.circuitBreakerConfig(CircuitBreakerConfig.custom().failureRateThreshold(3)
//								.waitDurationInOpenState(Duration.ofSeconds(2)).slidingWindowSize(2)
//								.slowCallRateThreshold(3).build()).timeLimiterConfig(
//										TimeLimiterConfig.custom().timeoutDuration(Duration.ofSeconds(3)).build());
//					}
//				}, "slow");
//			}
//		};
//	}

	@Bean
	public Customizer<Resilience4JCircuitBreakerFactory> customizeCircuitBreakerFactory() {
		return (factory) -> {
			factory.configure((builder) -> {
				builder.circuitBreakerConfig(CircuitBreakerConfig.custom().failureRateThreshold(3)
						.waitDurationInOpenState(Duration.ofSeconds(2)).slidingWindowSize(2).slowCallRateThreshold(3)
						.build())
						.timeLimiterConfig(TimeLimiterConfig.custom().timeoutDuration(Duration.ofSeconds(3)).build());
			}, "slow");
			factory.configure((builder) -> {
				builder.circuitBreakerConfig(CircuitBreakerConfig.custom().failureRateThreshold(3)
						.waitDurationInOpenState(Duration.ofSeconds(1)).slidingWindowSize(1).slowCallRateThreshold(2)
						.build())
						.timeLimiterConfig(TimeLimiterConfig.custom().timeoutDuration(Duration.ofSeconds(2)).build());
			}, "fast");
		};
	}

}








