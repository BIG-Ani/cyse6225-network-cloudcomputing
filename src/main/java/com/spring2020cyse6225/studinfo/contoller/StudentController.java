package com.spring2020cyse6225.studinfo.contoller;

import com.spring2020cyse6225.studinfo.datamodel.Student;
import com.spring2020cyse6225.studinfo.service.serviceImp.StudentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentServiceImp studentService;

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        List<Student> courseList = studentService.findAllStudents();

        return courseList;
    }

    @GetMapping("/student/{studentId}")
    public Student getStudentById(@PathVariable(value = "studentId") String studentId) {
        Student foundStudent = studentService.findStudentById(studentId);

        return foundStudent;
    }

    @PostMapping("/student")
    public Student addStudent(Student student) {
        studentService.addStudent(student);
        String newStudentId = String.valueOf(studentService.findAllStudents().size());

        return studentService.findStudentById(newStudentId);
    }

    @PutMapping("/student/{studentId}")
    public Student updateCourse(@PathVariable String studentId,
                                              Student student) {
        Student updateStudent = studentService.updateStudentInfo(studentId, student);

        return updateStudent;
    }

    @DeleteMapping("/student/{studentId}")
    public Student deleteCourse(@PathVariable String studentId) {
        Student deleteCourse = studentService.findStudentById(studentId);

        studentService.deleteStudent(studentId);
        return deleteCourse;
    }

    @GetMapping("/student/{studentId}/course/{courseId}")
    public void registerCourse(@PathVariable String studentId,
                               @PathVariable String courseId) {

        studentService.registerCourse(courseId, studentId);
    }

    @DeleteMapping("/student/{studentId}/course/{courseId}")
    public void dropCourse(@PathVariable String studentId,
                           @PathVariable String courseId) {

        studentService.dropCourse(courseId, studentId);
    }
}
