package com.spring2020cyse6225.studinfo.service.serviceInterface;

import com.spring2020cyse6225.studinfo.datamodel.Course;

import java.util.List;

public interface CourseService {

    /**
     * @Return: course name
     * @Time: 2/21/20
     *
     * @return*/
    Course addNewCourse(String courseName);

    /**
     * @Return: course name
     * @Time: 2/21/20
     **/
    String cancelCourse(String courseId);

    /**
     * @Description: update the course info without student list
     * @Time: 2/21/20
    **/
    Course updateCourse(String courseId, Course course);

    Course findCourseById(String courseId);

    List<Course> findAllCourses();

    /**
     * @Return: log: course name, prof name
     * @Time: 2/21/20
     **/
    void assignProfessor(String courseId, String professorId);

    /**
     * @Return: log: course name, ta name
     * @Time: 2/21/20
     **/
    void assignTA(String courseId, String studentId);
}
