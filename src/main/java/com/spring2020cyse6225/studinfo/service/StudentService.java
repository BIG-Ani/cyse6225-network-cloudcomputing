package com.spring2020cyse6225.studinfo.service;

import com.spring2020cyse6225.studinfo.dataSource.InMemoryDatabase;
import com.spring2020cyse6225.studinfo.datamodel.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {

    private static Map<String, Student> studentDB = InMemoryDatabase.getStudentDB();

    public List<Student> getAllStudents() {
        List<Student> studentList = new ArrayList<>();

        for (Student student : studentDB.values()) {
            studentList.add(student);
        }

        return studentList;
    }

    public Student getStudentById(String courseId) {
        Student foundStudent = studentDB.get(courseId);

        System.out.println("Course item retrieve: " + foundStudent);
        System.out.println(foundStudent.toString());

        return foundStudent;
    }

    public void addStudent(Student student) {
        // TODO leichenzhou - 2/20/20
        String studentId = String.valueOf(studentDB.size() + 1);
        student.setStudentId(studentId);

        studentDB.put(studentId, student);
    }

    public Student deleteStudent(String studentId) {
        Student deleteStudent = studentDB.get(studentId);

        studentDB.remove(studentId);
        return deleteStudent;
    }

    public Student updateStudent(String studentId, Student student) {
        Student updateStudent = studentDB.get(studentId);

        updateStudent.setStudentName(student.getStudentName());
        updateStudent.setImage(student.getImage());
        updateStudent.setProgramName(student.getProgramName());
        return updateStudent;
    }

}
