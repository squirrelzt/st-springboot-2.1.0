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

/**
 * 类名称: TimestampController
 * 类描述: 时间戳转换控制器
 * @author squirrel
 * @date 2019-09-09
 */
@Slf4j
@RestController
@RequestMapping("/timestampConvert")
public class TimestampController {

    private final CourseService courseService;

    public TimestampController(CourseService courseService) {
        this.courseService = courseService;
    }

    /**
     * 查询所有课程
     * @param id 序号
     * @return 课程集合
     */
    @PostMapping("/course")
    public List<Course> listCourses(@RequestParam("id") Long id) {
        log.info("入参: {}", id);
        try {
            return courseService.listCourses();
        } catch (ParseException e) {
            log.error("query course fail {}", e);
            return null;
        }
    }
}
