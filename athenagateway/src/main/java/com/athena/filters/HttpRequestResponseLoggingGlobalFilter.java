package com.athena.filters;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class HttpRequestResponseLoggingGlobalFilter implements GlobalFilter {
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		Mono<Void> response = null;

		System.out.println("received request : " + exchange.getRequest().getPath());
		response = chain.filter(exchange);
		System.out.println("completed the request : " + exchange.getRequest().getPath() + " with statusCode: "
				+ exchange.getResponse().getStatusCode().value());

		return response;
	}
}
