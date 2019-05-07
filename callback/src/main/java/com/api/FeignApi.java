package com.api;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/remote/feign")
public class FeignApi {

    @RequestMapping("/getname")
    public String demo(@RequestParam String name) {
        LOGGER.info("==============================");
        LOGGER.info(name);
        return name;
    }

    @RequestMapping("/data")
    public String getData(@RequestBody Object object) {
        LOGGER.info("远程参数: " + JSON.toJSONString(object));
        return "jack";
    }

}
