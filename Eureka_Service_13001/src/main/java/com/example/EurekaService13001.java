package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author 朱鹏宇
 * @Description
 * @create 2023-04-13 11:25
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaService13001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaService13001.class,args);
    }
}
