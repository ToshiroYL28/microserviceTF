package com.example.appbient_microservice_foro;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@OpenAPIDefinition
@EnableJpaAuditing
@SpringBootApplication
@EnableEurekaClient
public class AppbientMicroserviceForoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppbientMicroserviceForoApplication.class, args);
    }

}
