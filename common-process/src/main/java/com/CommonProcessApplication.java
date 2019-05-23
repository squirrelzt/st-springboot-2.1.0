package com;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * 类名称: CommonProcessApplication
 * 类描述: 启动类
 * @author squirrel
 * @date 2019-05-23
 */
@SpringBootApplication
public class CommonProcessApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(CommonProcessApplication.class)
                .properties("server.port=8080")
                .run();
    }
}
