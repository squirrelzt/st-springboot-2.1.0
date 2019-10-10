package com.jjwt;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class JjwtApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(JjwtApplication.class).run(args);
    }
}
