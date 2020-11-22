package com.functional.reduce;

import com.functional.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Slf4j
public class ReduceTest {

    @Test
    public void test() {
        User[] userArray = {
                User.builder().id(1).username("java").age(20).name("11").mobile("13111111111").build(),
                User.builder().id(2).username("javascript").age(30).name("2020").mobile("13222222222").build(),
                User.builder().id(3).username("golang").age(25).name("1.19").mobile("13333333333").build(),
        };
        List<User> userList = Arrays.asList(userArray);

        Integer sumByReduce = userList.stream()
                .map(User::getAge)
                .reduce(0, (Integer acc, Integer curr) -> {
                    log.info("acc ={}, curr ={}", acc, curr);
                    return acc + curr;
                });
        assertEquals(75L, (long)sumByReduce);

        Optional<User> useOptional = userList.stream()
                .reduce((acc, curr) -> {
                    return acc.getId() > curr.getId() ? acc : curr;
                });
        assertTrue(useOptional.isPresent());
        assertEquals(3L, (long)sumByReduce);
    }
}
