package com.convert;

import com.domain.MockPerson;
import com.domain.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 类名称: QueryConvert
 * 类描述: 类型转换
 * @author squirrel
 * @date 2019-05-23
 */
@Mapper
public interface QueryConvert {

    QueryConvert INSTANCE = Mappers.getMapper(QueryConvert.class);

    @Mappings({
            @Mapping(source = "account", target = "acctNo"),
            @Mapping(source = "accountName", target = "acctName")
    })
    Person convertMockPerson(MockPerson mockPerson);

    List<Person> convertMockPerson(List<MockPerson> list);
}
