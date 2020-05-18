package com.jjh.register;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableEurekaServer
@Configuration
public class ServiceRegistrationServer {

    public static void main(String[] args) {
        // Should be run first
        System.out.println("Starting Registration Server");
        // Tell Boot to look for registration-server.yml
        System.setProperty("spring.config.name", "registration-server");
        SpringApplication.run(ServiceRegistrationServer.class, args);
        System.out.println("Registration Server Started");
    }

    @ConditionalOnMissingBean
    @Bean
    public HttpTraceRepository httpTraceRepository() {
        return new InMemoryHttpTraceRepository();
    }
}
