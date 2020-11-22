package com.funtional.sort;


import lombok.val;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

public class SortTest {

    @Test
    public void givenCollections_withStream_thenSort() {
        List<String> list = Arrays.asList("Beijing", "Shagnhai", "Hebei");
        List<String> sortedList = list.stream().sorted().collect(toList());
        assertEquals("Beijing", sortedList.get(0));

        List<String> sortedListFunction = list.stream().sorted( (a, b) -> {
            return a.compareTo(b);
        }).collect(toList());
        assertEquals("Beijing", sortedListFunction.get(0));

    }
}
