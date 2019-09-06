package com.service;

import com.domain.Course;

import java.text.ParseException;
import java.util.List;

public interface CourseService {

    List<Course> listCourses() throws ParseException;
}
