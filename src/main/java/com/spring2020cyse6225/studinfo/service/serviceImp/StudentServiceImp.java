package com.spring2020cyse6225.studinfo.service.serviceImp;

import com.spring2020cyse6225.studinfo.dao.CourseDao;
import com.spring2020cyse6225.studinfo.dao.StudentDao;
import com.spring2020cyse6225.studinfo.datamodel.Student;
import com.spring2020cyse6225.studinfo.service.serviceInterface.StudentService;
import com.spring2020cyse6225.studinfo.util.CourseStudentUntilImp;
import com.spring2020cyse6225.studinfo.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService {

    @Autowired
    StudentDao studentDao;

    @Autowired
    CourseDao courseDao;

    @Autowired
    CourseStudentUntilImp courseStudentUntil;

    @Override
    public Student addStudent(Student student) {
        Student newStudent = studentDao.addStudent(student);

        return newStudent;
    }

    @Override
    public String deleteStudent(String studentId) {
        String deleteStudent = studentDao.deleteStudent(studentId).getStudentName();

        return deleteStudent;
    }

    @Override
    public Student updateStudentInfo(String studentId, Student student) {
        Student updateStudent = studentDao.updateStudent(studentId, student);
        return updateStudent;
    }

    @Override
    public Student findStudentById(String studentId) {
        Student foundStudent = studentDao.getStudentById(studentId);

        return foundStudent;
    }

    @Override
    public List<Student> findAllStudents() {
        return studentDao.getAllStudents();
    }

    /**
     * @param courseId
     * @param studentId
     * @Return: log: course name, student name
     * @Time: 2/21/20
     */
    @Override
    public void registerCourse(String courseId, String studentId) {
        int addCourseCode = courseStudentUntil.addCourseToStudentCourseList(studentId, courseId);
        int addStudentCode = courseStudentUntil.addStudentToCourse(courseId, studentId);

        String log = "\n>>>\n" +
                     MessageUtil.builtMessage(addCourseCode) + "\n" +
                     MessageUtil.builtMessage(addStudentCode);

        System.out.println(log);
    }

    /**
     * @param courseId
     * @param studentId
     * @Return: course name
     * @Time: 2/21/20
     */
    @Override
    public void dropCourse(String courseId, String studentId) {
        int dropCourseCode = courseStudentUntil.removeCourseFromStudentCourseList(studentId, courseId);
        int dropStudentCode = courseStudentUntil.removeStudentFromCourse(courseId, studentId);

        String log = "\n>>>\n" +
                     MessageUtil.builtMessage(dropCourseCode) + "\n" +
                     MessageUtil.builtMessage(dropStudentCode);

        System.out.println(log);
    }
}
