package com.spring2020cyse6225.studinfo.service.serviceImp;

import com.spring2020cyse6225.studinfo.dao.CourseDao;
import com.spring2020cyse6225.studinfo.dao.ProfessorDao;
import com.spring2020cyse6225.studinfo.dao.StudentDao;
import com.spring2020cyse6225.studinfo.datamodel.Course;
import com.spring2020cyse6225.studinfo.datamodel.Professor;
import com.spring2020cyse6225.studinfo.datamodel.Student;
import com.spring2020cyse6225.studinfo.service.serviceInterface.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImp implements CourseService {

    @Autowired
    CourseDao courseDao;

    @Autowired
    ProfessorDao professorDao;

    @Autowired
    StudentDao studentDao;

    @Override
    public Course addNewCourse(String courseName) {
        courseDao.addCourse(courseName);

        String courseId = String.valueOf(courseDao.getAllCourses().size());
        Course newCourse = courseDao.getCourseById(courseId);
        return newCourse;
    }

    @Override
    public String cancelCourse(String courseId) {
        String deleteCourse = courseDao.getCourseById(courseId).getCourseName();
        courseDao.deleteCourse(courseId);

        return deleteCourse;
    }

    @Override
    public Course updateCourse(String courseId, Course course) {
        return courseDao.updateCourse(courseId, course);
    }

    @Override
    public Course findCourseById(String courseId) {
        return courseDao.getCourseById(courseId);
    }

    @Override
    public List<Course> findAllCourses() {
        return courseDao.getAllCourses();
    }

    @Override
    public void assignProfessor(String courseId, String professorId) {
        Course course = courseDao.getCourseById(courseId);
        Professor professor = professorDao.getProfessor(professorId);
        course.setProfessor(professor);
        String log = ">>> assign the Prof-" + professorId + "." +
                course.getProfessor().getLastName() + " to course - " +
                course.getCourseName();

        System.out.println(log);
    }

    @Override
    public void assignTA(String courseId, String studentId) {
        Course course = courseDao.getCourseById(courseId);
        Student student = studentDao.getStudentById(studentId);
        course.setTeachingAssistant(student);
        String log = ">>> assign the TA/studentId-" + studentId + "." +
                course.getTeachingAssistant().getStudentName() + " to course - " +
                course.getCourseName();

        System.out.println(log);
    }
}
