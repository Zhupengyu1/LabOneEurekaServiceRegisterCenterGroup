package org.example.fliter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author 朱鹏宇
 * @Description
 * @create 2023-04-26 15:05
 */

@Component
public class AuthFilter implements GlobalFilter {
    /**
     *
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        jwt等token认证，自己实现
//        实现简单实例
        String token = exchange.getRequest().getQueryParams().getFirst("token");
//        jwt认证框架
//        请求不合理
        if(token==null){
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }
//        继续执行过滤器的下一个资源
        return chain.filter(exchange);
    }
}
