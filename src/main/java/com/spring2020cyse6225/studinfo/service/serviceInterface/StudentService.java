package com.spring2020cyse6225.studinfo.service.serviceInterface;

import com.spring2020cyse6225.studinfo.datamodel.Student;

import java.util.List;

public interface StudentService {

    Student addStudent(Student student);

    String deleteStudent(String studentId);

    Student updateStudentInfo(String studentId, Student student);

    Student findStudentById(String studentId);

    List<Student> findAllStudents();

    /**
     * @Return: log: course name, student name
     * @Time: 2/21/20
    **/
    void registerCourse(String courseId, String studentId);

    /**
     * @Return: course name
     * @Time: 2/21/20
    **/
    void dropCourse(String courseId, String studentId);
}
