package pl.umcs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CheckerMainApp {
    public static void main(String[] args) {
        SpringApplication.run(CheckerMainApp.class, args);
    }
}
