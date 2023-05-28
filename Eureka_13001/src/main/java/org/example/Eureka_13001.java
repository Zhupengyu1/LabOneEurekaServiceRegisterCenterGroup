package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author 朱鹏宇
 * @Description
 * @create 2023-03-15 14:36
 */
@SpringBootApplication
@EnableEurekaServer//Eureka注册中心
public class Eureka_13001 {
    public static void main(String[] args) {
        SpringApplication.run(Eureka_13001.class,args);
    }

}
