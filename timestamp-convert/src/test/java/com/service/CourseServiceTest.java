package com.service;

import com.alibaba.fastjson.JSON;
import com.domain.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CourseServiceTest {

    @Autowired
    private CourseService courseService;

    @Test
    public void listCourses() {
        List<Course> list = null;
        try {
            list = courseService.listCourses();
            System.out.println(JSON.toJSONString(list));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
