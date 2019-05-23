package com.controller;

import com.domain.Person;
import com.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public Person getPersonByName(@RequestBody String name) {
        log.info("参数: " + name);
        return personService.getPersonByName(name);
    }
}
