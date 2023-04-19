package com.example;

import com.example.loadbalance.CustomLoadBalanceConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 朱鹏宇
 * @Description
 * @create 2023-04-13 11:40
 */
@SpringBootApplication
@EnableFeignClients
@LoadBalancerClient(name="provider-server",configuration = CustomLoadBalanceConfiguration.class)
public class Service12001 {
    public static void main(String[] args) {
        SpringApplication.run(Service12001.class,args);
    }
}
