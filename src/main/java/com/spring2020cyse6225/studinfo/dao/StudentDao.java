package com.spring2020cyse6225.studinfo.dao;

import com.spring2020cyse6225.studinfo.dataSource.InMemoryDatabase;
import com.spring2020cyse6225.studinfo.datamodel.Student;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class StudentDao {

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

        System.out.println("Student item retrieve:\n" + foundStudent);

        return foundStudent;
    }

    public Student addStudent(Student student) {
        String studentId = String.valueOf(studentDB.size() + 1);
        student.setStudentId(studentId);
        student.setProgramName(student.getProgramName());

        studentDB.put(studentId, student);

        return student;
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
