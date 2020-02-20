package com.spring2020cyse6225.studinfo.contoller;

import com.spring2020cyse6225.studinfo.datamodel.Student;
import com.spring2020cyse6225.studinfo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    /**
     * @Description: localhost:8080/students
     * @Params: get
     * @Time: 2/20/20
    **/
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        List<Student> courseList = studentService.getAllStudents();

        return courseList;
    }

    /**
     * @Description: localhost:8080/student/5
     * @Params: get
     * @Time: 2/20/20
    **/
    @GetMapping("/student/{studentId}")
    public Student getStudentById(@PathVariable(value = "studentId") String studentId) {
        Student foundStudent = studentService.getStudentById(studentId);

        return foundStudent;
    }

    /**
     * @Description: localhost:8080/student
     * @Params: post
     * @Time: 2/20/20
    **/
    @PostMapping("/student")
    public Student addStudent(Student student) {
        studentService.addStudent(student);
        String newStudentId = String.valueOf(studentService.getAllStudents().size());

        return studentService.getStudentById(newStudentId);
    }

    /**
     * @Description: localhost:8080/student/8
     * @Params: put
     * @Time: 2/20/20
    **/
    @PutMapping("/student/{studentId}")
    public Student updateCourse(@PathVariable String studentId,
                                              Student student) {
        Student updateStudent = studentService.updateStudent(studentId, student);

        return updateStudent;
    }

    /**
     * @Description: localhost:8080/student/8
     * @Params: delete
     * @Time: 2/20/20
    **/
    @DeleteMapping("/student/{studentId}")
    public Student deleteCourse(@PathVariable String studentId) {
        Student deleteCourse = studentService.getStudentById(studentId);

        studentService.deleteStudent(studentId);
        return deleteCourse;
    }

}
