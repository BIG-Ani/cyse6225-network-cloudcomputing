package com.spring2020cyse6225.studinfo.service.awsServiceInterface;

import com.spring2020cyse6225.studinfo.awsDataSchema.Student;

public interface AwsStudentServiceInterface {

    Student addStudent(Student student);

    Student deleteStudent(Long studentId);

    Student updateStudent(Long studentId, Student student);

    Student findStudentById(Long studentId);
}
