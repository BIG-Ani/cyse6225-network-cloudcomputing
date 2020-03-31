package com.spring2020cyse6225.studinfo.contoller;

//import com.spring2020cyse6225.studinfo.datamodel.Course;
import com.spring2020cyse6225.studinfo.awsDataSchema.Course;
import com.spring2020cyse6225.studinfo.service.awsServiceImp.AwsCourseServiceImp;
import com.spring2020cyse6225.studinfo.service.serviceImp.CourseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseServiceImp courseService;

    @Autowired
    AwsCourseServiceImp awsCourseService;

//    @GetMapping("/courses")
//    public List<Course> getAllCourses() {
//        List<Course> courseList = courseService.findAllCourses();
//
//        return courseList;
//    }
    
    @GetMapping("/course/{courseId}")
    public Course getCourseById(@PathVariable(value = "courseId") String courseId) {
//        Course foundCourse = courseService.findCourseById(courseId);

        Course foundCourse = awsCourseService.findCourseById(Long.parseLong(courseId));

        return foundCourse;
    }

    @PostMapping("/course")
    public Course addCourse(Course course) {
//        Course addCourse = courseService.addNewCourse(course.getCourseName());
        Course addCourse = awsCourseService.addCourse(course);

        return addCourse;
    }

    @PutMapping("/course/{courseId}")
    public Course updateCourse(@PathVariable String courseId,
                                Course course) {
//        Course updateCourse = courseService.updateCourse(courseId, course);

        Course updateCourse = awsCourseService.updateCourse(
                Long.parseLong(courseId),
                course);

        return updateCourse;
    }


    @DeleteMapping("/course/{courseId}")
    public Course deleteCourse(@PathVariable String courseId) {
//        Course deleteCourse = courseService.findCourseById(courseId);

        Course deleteCourse = awsCourseService.deleteCourse(Long.parseLong(courseId));

        courseService.cancelCourse(courseId);
        return deleteCourse;
    }

//    @PutMapping("/course/{courseId}/professor/{professorId}")
//    public Course assignCourseProfessor(@PathVariable String courseId,
//                                        @PathVariable String professorId) {
//
//        courseService.assignProfessor(courseId, professorId);
//        Course course = courseService.findCourseById(courseId);
//
//        return course;
//    }
//
//    @PutMapping("/course/{courseId}/student/{studentId}")
//    public Course assignCourseTA(@PathVariable String courseId,
//                                 @PathVariable String studentId) {
//
//        courseService.assignTA(courseId, studentId);
//        Course course = courseService.findCourseById(courseId);
//
//        return course;
//    }
}
