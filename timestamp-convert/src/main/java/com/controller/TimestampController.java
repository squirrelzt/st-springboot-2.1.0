package com.controller;

import com.domain.Course;
import com.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/timestampConvert")
public class TimestampController {

    private final CourseService courseService;

    public TimestampController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/course")
    public List<Course> listCourses(@RequestParam("id") Long id) {
        System.out.println(id);
        try {
            return courseService.listCourses();
        } catch (ParseException e) {
            log.error("query course fail {}", e);
            return null;
        }
    }
}
