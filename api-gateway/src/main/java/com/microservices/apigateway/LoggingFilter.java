package com.microservices.apigateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;


@Component
public class LoggingFilter implements GlobalFilter {

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		
		Logger logger = LoggerFactory.getLogger(LoggingFilter.class);
		logger.info("Path of Request Received is -> {}",exchange.getRequest().getPath());
				
		return chain.filter(exchange);
	}

}