package com.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//@EnableDiscoveryClient
@EnableFeignClients
public class ApplicationStarter80 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationStarter80.class);
    }
}
