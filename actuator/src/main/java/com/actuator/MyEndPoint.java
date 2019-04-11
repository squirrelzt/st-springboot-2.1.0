package com.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;

import java.util.HashMap;
import java.util.Map;

@Endpoint(id = "squirrelzt")
public class MyEndPoint {
    @ReadOperation
    public Map<String,String> test(){
        Map<String,String> result = new HashMap<>();
        result.put("name","squirrelzt");
        result.put("age","25");
        return result;
    }
}
