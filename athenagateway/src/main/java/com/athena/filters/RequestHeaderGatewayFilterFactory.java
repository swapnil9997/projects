package com.athena.filters;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

@Component
public class RequestHeaderGatewayFilterFactory extends AbstractGatewayFilterFactory<HeaderConfig> {

	public RequestHeaderGatewayFilterFactory() {
		super(HeaderConfig.class);
	}

	@Override
	public GatewayFilter apply(HeaderConfig config) {
		RequestHeaderGatewayFilter requestHeaderGatewayFilter = new RequestHeaderGatewayFilter(config);
		return requestHeaderGatewayFilter;
	}

}
