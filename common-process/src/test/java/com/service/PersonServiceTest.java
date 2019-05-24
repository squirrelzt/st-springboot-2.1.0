package com.service;

import com.alibaba.fastjson.JSON;
import com.domain.Person;
import com.result.JsonResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PersonServiceTest {

    @Autowired
    PersonService personService;

    @Test
    public void listPersons() {
        List<Person> list = personService.listPersons();
        System.out.println(JSON.toJSONString(list));
    }

    @Test
    public void getPersonByName() {
        String name = "squirrel";
        JsonResult<Person> jsonResult = personService.getPersonByName(name);
        System.out.println(JSON.toJSONString(jsonResult));
    }
}
