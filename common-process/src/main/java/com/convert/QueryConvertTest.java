package com.convert;

import com.alibaba.fastjson.JSON;
import com.domain.MockPerson;
import com.domain.Person;

public class QueryConvertTest {
    public static void main(String[] args) {
        MockPerson mockPerson =  new MockPerson();
        mockPerson.setAccountName("ICBC");
        mockPerson.setAccount("1234324");
        Person person = QueryConvert.INSTANCE.convertMockPerson(mockPerson);
        System.out.println(JSON.toJSONString(person));
    }
}
