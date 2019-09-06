package com;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class TimestampApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(TimestampApplication.class).run(args);
    }
}
