package com.service;

import com.domain.Course;

import java.text.ParseException;
import java.util.List;

/**
 * 类名称: CourseService
 * 类描述: 课程服务接口
 * @author squirrel
 * @date 2019-09-09
 */
public interface CourseService {

    /**
     *
     * @return
     * @throws ParseException
     */
    List<Course> listCourses() throws ParseException;
}
