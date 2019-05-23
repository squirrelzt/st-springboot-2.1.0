package com.service;

import com.domain.Person;

import java.util.List;

/**
 * 类名称: PersonService
 * 类描述: 服务接口
 * @author squirrel
 * @date 2019-05-23
 */
public interface PersonService {

    List<Person> listPersons();

    Person getPersonByName(String name);
}
