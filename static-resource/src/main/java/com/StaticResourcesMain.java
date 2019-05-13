package com;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class StaticResourcesMain {

    public static void main(String[] args) {
        new SpringApplicationBuilder(StaticResourcesMain.class).run(args);
    }
}
