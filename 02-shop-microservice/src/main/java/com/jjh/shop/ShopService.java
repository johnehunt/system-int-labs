package com.jjh.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class ShopService {

    public static void main(String[] args) {
        System.out.println("Starting the Shop Service");

        // Will configure using shop-service.yml
        System.setProperty("spring.config.name", "shop-service");

        SpringApplication.run(ShopService.class, args);
        System.out.println("Shop Service started");
    }

    @LoadBalanced    // Make sure to create the load-balanced template
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
