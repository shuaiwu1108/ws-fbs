package com.shuaiwu.gateway.filter;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import lombok.Data;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class CheakAuthGatewayFilterFactory extends AbstractGatewayFilterFactory<CheakAuthGatewayFilterFactory.Config> {
    public CheakAuthGatewayFilterFactory() {
        super(CheakAuthGatewayFilterFactory.Config.class);
    }

    public List<String> shortcutFieldOrder() {
        return Arrays.asList("value");
    }

    public GatewayFilter apply(CheakAuthGatewayFilterFactory.Config config) {
        return new GatewayFilter() {
            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                if (exchange.getRequest().getQueryParams().getFirst("name").equals(config.getValue())){
                    return chain.filter(exchange);
                }else {
                    exchange.getResponse().setStatusCode(HttpStatus.NOT_FOUND);
                    return exchange.getResponse().setComplete();
                }
            }
        };
    }

    @Data
    public static class Config {
        String value;
    }
}
