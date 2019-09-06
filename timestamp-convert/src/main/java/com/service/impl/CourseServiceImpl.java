package com.service.impl;

import com.domain.Course;
import com.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class CourseServiceImpl implements CourseService {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    @Override
    public List<Course> listCourses() throws ParseException {
        return getData();
    }

    private List<Course> getData() throws ParseException {
        List<Course> list = new ArrayList<>(3);

        Course java =  new Course();
        java.setId(1);
        java.setName("java");
        java.setCreateDate(sdf.parse("2018-05-01"));
        java.setUpdateDate(sdf.parse("2019-08-15"));
        list.add(java);

        Course python =  new Course();
        python.setId(2);
        python.setName("python");
        python.setCreateDate(sdf.parse("2019-10-01"));
        python.setUpdateDate(sdf.parse("2020-05-30"));
        list.add(python);

        Course golang =  new Course();
        golang.setId(2);
        golang.setName("golang");
        golang.setCreateDate(sdf.parse("2020-06-01"));
        golang.setUpdateDate(sdf.parse("2020-10-30"));
        list.add(golang);

        return list;
    }
}
