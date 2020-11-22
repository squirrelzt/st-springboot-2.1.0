package com.functional.sort;


import com.functional.domain.User;
import org.junit.Test;

import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

public class SortTest {

    @Test
    public void givenCollections_withStream_thenSort() {


        List<String> list = Arrays.asList("Beijing", "Shagnhai", "Hebei");
        List<String> sortedList = list.stream().sorted().collect(toList());
        assertEquals("Beijing", sortedList.get(0));

        //降序排列
        List<String> sortedListReverse = list.stream().sorted((a, b) -> {
            return b.compareTo(a);
        }).collect(toList());

        List<String> sortedListFunction = list.stream().sorted(String::compareTo).collect(toList());
        assertEquals("Beijing", sortedListFunction.get(0));

        List<String> sortedListComparatorFunc = list.stream().sorted(Comparator.naturalOrder()).collect(toList());
        assertEquals("Beijing", sortedListComparatorFunc.get(0));

        // 降序排列
        List<String> sortedListComparatorReverseFunc = list.stream().sorted(Comparator.reverseOrder()).collect(toList());
        assertEquals("Shagnhai", sortedListComparatorReverseFunc.get(0));

        User[] userArray = {
                User.builder().id(1).username("java").name("11").mobile("13111111111").build(),
                User.builder().id(2).username("javascript").name("2020").mobile("13222222222").build(),
                User.builder().id(3).username("golang").name("1.19").mobile("13333333333").build(),
        };
        List<User> userList = Arrays.asList(userArray);
        List<User> sortedUserList = userList.stream().sorted((a, b) -> {
            return a.getUsername().compareTo(b.getUsername());
        }).collect(toList());
        assertEquals("golang", sortedUserList.get(0).getUsername());

        List<User> sortedComparatorUserList = userList.stream().sorted(Comparator.comparing(user ->
                user.getUsername(), (a, b) -> {
            return a.compareTo(b);
        })).collect(toList());
        assertEquals("golang", sortedUserList.get(0).getUsername());

        Collator sortedByZhCN = Collator.getInstance(Locale.SIMPLIFIED_CHINESE);
        List<User> sortedComparatorLocalUserList = userList.stream().sorted(Comparator.comparing(
                User::getUsername,
                sortedByZhCN
        )).collect(toList());
        assertEquals("golang", sortedUserList.get(0).getUsername());
    }
}
