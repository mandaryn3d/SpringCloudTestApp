package pl.umcs;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class CloudContractMainApp {

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {System.out.println("Hey, it works!");};
    }

    public static void main(String[] args) {
        SpringApplication.run(CloudContractMainApp.class, args);
    }
}
