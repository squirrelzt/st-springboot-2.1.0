package com.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 类名称: MyFeignClient
 * 类描述: feign 客户端
 * @author squirrel
 * @date 2019-04-29
 */
@FeignClient(name = "myFeign", url = "http://localhost:8080/remote")
public interface MyFeignClient {

    @RequestMapping("/feign/data")
    String getData(@RequestBody Object object);
}
