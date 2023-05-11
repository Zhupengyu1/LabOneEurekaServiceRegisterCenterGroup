package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author 朱鹏宇
 * @Description
 * @create 2023-05-11 9:08
 */
@SpringBootApplication
@EnableEurekaServer
public class Eureka_Service_13000 {
    public static void main(String[] args) {
        SpringApplication.run(Eureka_Service_13000.class,args);
    }
}
