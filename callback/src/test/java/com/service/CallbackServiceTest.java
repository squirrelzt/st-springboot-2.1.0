package com.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CallbackServiceTest {

    @Autowired
    CallbackService callbackService;

    @Test
    public void callback() throws Exception {
        String url = "http://localhost:8080/gateway/callback";
        String resp = callbackService.callback(url);
        System.out.println(resp);
    }
}
