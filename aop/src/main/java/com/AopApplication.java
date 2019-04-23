package com;

import com.service.Speakable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopApplication {

    private final Speakable speakable;

    public AopApplication(Speakable speakable) {
        this.speakable = speakable;
    }

    public static void main(String[] args) {
        SpringApplication.run(AopApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            // spring aop
            System.out.println("******** spring aop ******** ");
            speakable.sayHi();
            speakable.sayBye();
            System.exit(0);
        };
    }
}
