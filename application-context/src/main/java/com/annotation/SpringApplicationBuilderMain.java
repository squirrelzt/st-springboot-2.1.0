package com.annotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.LinkedHashMap;
import java.util.Map;

@SpringBootApplication
public class SpringApplicationBuilderMain {
    public static void main(String[] args) {
//        new SpringApplicationBuilder(SpringApplicationBuilderMain.class)
//                //端口为0，系统自动分配端口
//                .properties("server.port=0")
//                .run(args);

        // 等价于
        SpringApplication springApplication = new SpringApplication(SpringApplicationBuilderMain.class);
        Map<String, Object> properties = new LinkedHashMap<>();
        properties.put("server.port", "0");
        springApplication.setDefaultProperties(properties);
        springApplication.run(args);
    }
}
