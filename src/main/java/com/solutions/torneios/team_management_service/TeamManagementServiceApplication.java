package com.solutions.torneios.team_management_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication//(exclude = {DataSourceAutoConfiguration.class })
@EnableEurekaClient
 public class TeamManagementServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeamManagementServiceApplication.class, args);
    }

}
