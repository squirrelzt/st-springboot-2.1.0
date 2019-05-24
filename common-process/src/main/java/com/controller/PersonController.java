package com.controller;

import com.alibaba.fastjson.JSON;
import com.check.Asserts;
import com.check.Check;
import com.domain.Person;
import com.result.JsonResult;
import com.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 类名称: PersonController
 * 类描述: 控制器
 * @author squirrel
 * @date 2019-05-23
 */
@Slf4j
@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping("/queryAll")
    public List<Person> listPersons() {
        return personService.listPersons();
    }

    @RequestMapping("/queryByName")
    public JsonResult<Person> getPersonByName(@RequestBody Object obj) {
        Map jsonMap = (Map)JSON.toJSON(obj);
        Asserts.isNotNull(jsonMap.get("name"), "name 不能为空");
        String name = (String)jsonMap.get("name");
        log.info("参数: " + name);
        JsonResult<Person> jsonResult = personService.getPersonByName(name);
        Check.checkResultParam(jsonResult);
        return jsonResult;
    }
}
