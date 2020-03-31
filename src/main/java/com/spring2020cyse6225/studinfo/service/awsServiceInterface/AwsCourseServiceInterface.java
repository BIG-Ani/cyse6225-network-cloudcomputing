package com.spring2020cyse6225.studinfo.service.awsServiceInterface;

import com.spring2020cyse6225.studinfo.awsDataSchema.Course;

import java.util.List;

public interface AwsCourseServiceInterface {

    Course addCourse(Course course);

    Course deleteCourse(Long courseId);

    Course updateCourse(Long courseId, Course newCourse);

    Course findCourseById(Long courseId);

    List<Course> findAllCourses();
}
