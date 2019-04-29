package com.api;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class FeignApi {

    @RequestMapping("/one/getname")
    public String demo(@RequestBody String name) {
        System.out.println("==============================");
        System.out.println(name);
        return "jack";
    }

    @RequestMapping("/remote/feign/data")
    public String getData(@RequestBody Object object) {
        LOGGER.info("远程参数: " + JSON.toJSONString(object));
        return "jack";
    }
}
