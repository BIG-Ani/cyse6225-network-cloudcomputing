package com.spring2020cyse6225.studinfo.util;

import com.spring2020cyse6225.studinfo.status.StudentOptResCode;
import com.spring2020cyse6225.studinfo.dao.CourseDao;
import com.spring2020cyse6225.studinfo.dao.StudentDao;
import com.spring2020cyse6225.studinfo.datamodel.Course;
import com.spring2020cyse6225.studinfo.datamodel.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CourseStudentUntilImp implements CourseStudentUtil {

    @Autowired
    CourseDao courseDao;

    @Autowired
    StudentDao studentDao;

    @Override
    public int addStudentToCourse(String courseId, String studentId) {
        Course course = courseDao.getCourseById(courseId);
        Student student = studentDao.getStudentById(studentId);

        Map<String, String> courseEnrolledStudents = course.getEnrolledStudents();

        if (courseEnrolledStudents.containsKey(studentId) &&
            student.getCourseList().containsKey(courseId)) {

            return StudentOptResCode.COURSE_REG_ALREADY_REG.statusCode;
        } else {
            courseEnrolledStudents.put(studentId, student.getStudentName());

            return StudentOptResCode.COURSE_ADD_STUDENT_SUCCESS.statusCode;
        }
    }

    @Override
    public int removeStudentFromCourse(String courseId, String studentId) {
        Course course = courseDao.getCourseById(courseId);
        Student student = studentDao.getStudentById(studentId);

        Map<String, String> courseEnrolledStudents = course.getEnrolledStudents();

        if (!courseEnrolledStudents.containsKey(studentId) &&
            !student.getCourseList().containsKey(courseId)) {

            return StudentOptResCode.COURSE_RM_ALREADY_RM.statusCode;
        } else {
            courseEnrolledStudents.remove(studentId);

            return StudentOptResCode.COURSE_RM_STUDENT_SUCCESS.statusCode;
        }
    }

    @Override
    public int addCourseToStudentCourseList(String studentId, String courseId) {
        Course course = courseDao.getCourseById(courseId);
        Student student = studentDao.getStudentById(studentId);

        Map<String, String> studentCourseList = student.getCourseList();

        if (course.getEnrolledStudents().containsKey(studentId) &&
            studentCourseList.containsKey(courseId)) {

            return StudentOptResCode.STUDENT_ADD_COURSE_ALREADY.statusCode;
        } else {
            studentCourseList.put(courseId, course.getCourseName());

            return StudentOptResCode.STUDENT_ADD_COURSE_SUCCESS.statusCode;
        }
    }

    @Override
    public int removeCourseFromStudentCourseList(String studentId, String courseId) {
        Course course = courseDao.getCourseById(courseId);
        Student student = studentDao.getStudentById(studentId);

        Map<String, String> studentCourseList = student.getCourseList();

        if (!course.getEnrolledStudents().containsKey(studentId) &&
             !studentCourseList.containsKey(courseId)) {

            return StudentOptResCode.STUDENT_RM_COURSE_ALREADY.statusCode;
        } else {
            studentCourseList.remove(courseId);

            return StudentOptResCode.STUDENT_RM_COURSE_SUCCESS.statusCode;
        }
    }
}
