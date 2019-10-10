package com.jjwt.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/jjwt")
public class JsonController {

    @RequestMapping("/getToken")
    public String getToken() {
        return "token";
    }
}
