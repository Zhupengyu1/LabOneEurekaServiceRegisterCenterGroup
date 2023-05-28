package org.example;

import org.example.loadbalance.CustomLoadBalanceConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 朱鹏宇
 * @Description
 * @create 2023-03-08 14:58
 */
@SpringBootApplication
@EnableFeignClients
//指定策略
@LoadBalancerClient(name="provider-server",configuration = CustomLoadBalanceConfiguration.class)
public class Consumer_12000 {
    public static void main(String[] args) {
        SpringApplication.run(Consumer_12000.class,args);
    }
}





