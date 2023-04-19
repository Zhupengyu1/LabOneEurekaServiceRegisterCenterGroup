package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 朱鹏宇
 * @Description
 * @create 2023-04-13 11:42
 */
@SpringBootApplication
@EnableFeignClients
public class Service12000 {
    public static void main(String[] args) {
        SpringApplication.run(Service12000.class,args);
    }
}
