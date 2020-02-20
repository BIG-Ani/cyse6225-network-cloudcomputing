package com.spring2020cyse6225.studinfo.contoller;

import com.spring2020cyse6225.studinfo.datamodel.Course;
import com.spring2020cyse6225.studinfo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseService courseService;

    /**
     * @Description: localhost:8080/courses
     * @Params: get
     * @Time: 2/20/20
    **/ 
    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        List<Course> courseList = courseService.getAllCourses();

        return courseList;
    }
    
    /**
     * @Description: localhost:8080/course/1
     * @Params: get
     * @Time: 2/20/20
    **/ 
    @GetMapping("/course/{courseId}")
    public Course getCourseById(@PathVariable(value = "courseId") String courseId) {
        Course foundCourse = courseService.getCourseById(courseId);

        return foundCourse;
    }

    /**
     * @Description: localhost:8080/course
     * @Params: post
     * @Time: 2/20/20
    **/
    @PostMapping("/course")
    public Course addCourse(Course course) {
        courseService.addCourse(course.getCourseName());

        return courseService.getCourseById(String.valueOf(courseService.getAllCourses().size()));
    }

    @PutMapping("/course/{courseId}")
    public Course updateCourse(@PathVariable String courseId,
                                Course course) {
        Course updateCourse = courseService.getCourseById(courseId);

        updateCourse.setCourseName(course.getCourseName());
        return updateCourse;
    }

    @DeleteMapping("/course/{courseId}")
    public Course deleteCourse(@PathVariable String courseId) {
        Course deleteCourse = courseService.getCourseById(courseId);

        courseService.deleteCourse(courseId);
        return deleteCourse;
    }

}
