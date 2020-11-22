package com.functional.flatmap;

import com.functional.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Slf4j
public class FlatMapTest {

    @Test
    public void test() {
        User[] userArray = {
                User.builder().id(1).username("java").name("11").mobile("13111111111").roles(List.of("back","front")).build(),
                User.builder().id(2).username("javascript").name("2020").mobile("13222222222").roles(List.of("front")).build(),
                User.builder().id(3).username("golang").name("1.19").mobile("13333333333").roles(List.of("back")).build(),
        };
        List<User> userList = Arrays.asList(userArray);

        List<List<String>> list = userList.stream()
                .map(user -> user.getRoles())
                .peek(roles -> log.info("roles={}", roles))
                .collect(toList());
        log.info("list={}", list);

        List<String> flatMapList = userList.stream()
                .flatMap(user -> user.getRoles().stream())
                .peek(role -> log.info("roles={}", role))
                .collect(toList());
        log.info("flatMapList={}", flatMapList);
    }
}
