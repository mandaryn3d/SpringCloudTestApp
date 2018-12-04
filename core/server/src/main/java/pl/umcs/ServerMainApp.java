package pl.umcs;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaServer
public class ServerMainApp {

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {System.out.println("Hey, it works!");};
    }

    public static void main(String[] args) {
        SpringApplication.run(ServerMainApp.class, args);
    }
}
