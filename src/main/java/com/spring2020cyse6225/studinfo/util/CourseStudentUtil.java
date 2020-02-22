package com.spring2020cyse6225.studinfo.util;

public interface CourseStudentUtil {

    int addStudentToCourse(String courseId, String studentId);

    int removeStudentFromCourse(String courseId, String studentId);

    int addCourseToStudentCourseList(String studentId, String courseId);

    int removeCourseFromStudentCourseList(String studentId, String courseId);

}
