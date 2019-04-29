package com.controller;

import com.alibaba.fastjson.JSON;
import com.client.MyFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 类名称: FeignController
 * 类描述: feign 控制器
 * @author squirrel
 * @date 2019-04-29
 */
@Slf4j
@RestController
@RequestMapping("/feign")
public class FeignController {

    @Resource
    MyFeignClient myFeignClient;

    @RequestMapping("/getData")
    public String getData(@RequestBody Object object) {
        LOGGER.info("参数: " + JSON.toJSONString(object));
        return myFeignClient.getData(object);
    }
}
