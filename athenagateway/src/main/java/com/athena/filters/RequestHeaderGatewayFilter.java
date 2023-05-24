package com.athena.filters;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

public class RequestHeaderGatewayFilter implements GatewayFilter {
	private HeaderConfig headerConfig;

	public RequestHeaderGatewayFilter(HeaderConfig headerConfig) {
		this.headerConfig = headerConfig;
	}

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		Mono<Void> response = null;
		
		String value = ServerWebExchangeUtils.expand(exchange, headerConfig.getValue());
		ServerHttpRequest request = exchange.getRequest();
		request.mutate().headers(httpHeaders -> httpHeaders.add(headerConfig.getName(), value))
				.build();

		response = chain.filter(exchange.mutate().request(request).build());
		return response;
	}

}
