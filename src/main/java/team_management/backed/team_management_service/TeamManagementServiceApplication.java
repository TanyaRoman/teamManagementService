package team_management.backed.team_management_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import team_management.backed.team_management_service.controller.TestHelloWorld;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class TeamManagementServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeamManagementServiceApplication.class, args);
    }

}
