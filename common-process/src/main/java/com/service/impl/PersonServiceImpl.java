package com.service.impl;

import com.alibaba.fastjson.JSON;
import com.convert.QueryConvert;
import com.domain.MockPerson;
import com.domain.Person;
import com.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名称: PersonServiceImpl
 * 类描述: 服务接口实现类
 * @author squirrel
 * @date 2019-05-23
 */
@Slf4j
@Service
public class PersonServiceImpl implements PersonService {

    private static List<MockPerson> mockPersonList;

    static {
        mockPersonList = new ArrayList<>(3);
        MockPerson mockPerson1 = new MockPerson();
        mockPerson1.setName("squirrel");
        mockPerson1.setAge("20");
        mockPerson1.setGender("man");
        mockPerson1.setSchool("qinghua");
        mockPerson1.setAccount("62100000000000000001");
        mockPerson1.setAccountName("ICBC");
        mockPersonList.add(mockPerson1);

        MockPerson mockPerson2 = new MockPerson();
        mockPerson2.setName("lucy");
        mockPerson2.setAge("21");
        mockPerson2.setGender("woman");
        mockPerson2.setSchool("beida");
        mockPerson2.setAccount("62100000000000000002");
        mockPerson2.setAccountName("CMP");
        mockPersonList.add(mockPerson2);

        MockPerson mockPerson3 = new MockPerson();
        mockPerson3.setName("jim");
        mockPerson3.setAge("22");
        mockPerson3.setGender("man");
        mockPerson3.setSchool("zheda");
        mockPerson3.setAccountName("PAB");
        mockPerson3.setAccount("62100000000000000003");
        mockPersonList.add(mockPerson3);
    }
    @Override
    public List<Person> listPersons() {
        log.info("转换前数据List<MockPerson>: " + JSON.toJSONString(mockPersonList));
        List<Person> list = QueryConvert.INSTANCE.convertMockPerson(mockPersonList);
        log.info("转换后数据List<Person>: " + JSON.toJSONString(list));
        return list;
    }

    @Override
    public Person getPersonByName(String name) {
        Person person = null;
        for (int i = 0; i < mockPersonList.size(); i++) {
            MockPerson mockPerson = mockPersonList.get(i);
            if (mockPerson.getName().equals(name)) {
                log.info("转换前数据MockPerson: " + JSON.toJSONString(mockPerson));
                person = QueryConvert.INSTANCE.convertMockPerson(mockPerson);
                log.info("转换后数据Person: " + JSON.toJSONString(person));
            }
        }
        return person;
    }
}
