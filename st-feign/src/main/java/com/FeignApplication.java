package com;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 类名称: FeignApplication
 * 类描述: feign 启动类
 * @author squirrel
 * @date 2019-04-29
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class FeignApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(FeignApplication.class)
                .properties("server.port=8081")
                .run(args);
    }
}
