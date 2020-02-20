package com.spring2020cyse6225.studinfo.service;

import com.spring2020cyse6225.studinfo.dataSource.InMemoryDatabase;
import com.spring2020cyse6225.studinfo.datamodel.Course;
import com.spring2020cyse6225.studinfo.datamodel.Lecture;
import com.spring2020cyse6225.studinfo.datamodel.Professor;
import com.spring2020cyse6225.studinfo.datamodel.Student;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CourseService {

    private static HashMap<String, Course> courseDB = InMemoryDatabase.getCourseDB();
    private static HashMap<String, Student> studentDB = InMemoryDatabase.getStudentDB();
    private static HashMap<Long, Professor> professorDB = InMemoryDatabase.getProfessorDB();

    public CourseService() {
        init();
    }

    private static void init() {
        courseDB.get("1").setProfessor(professorDB.get(1));
        courseDB.get("2").setProfessor(professorDB.get(2));
        courseDB.get("3").setProfessor(professorDB.get(3));
        courseDB.get("4").setProfessor(professorDB.get(4));
        courseDB.get("5").setProfessor(professorDB.get(5));

        courseDB.get("1").getEnrolledStudents().put("1", studentDB.get("1"));
        courseDB.get("1").getEnrolledStudents().put("6", studentDB.get("6"));
        courseDB.get("2").getEnrolledStudents().put("2", studentDB.get("2"));
        courseDB.get("2").getEnrolledStudents().put("7", studentDB.get("7"));
        courseDB.get("3").getEnrolledStudents().put("3", studentDB.get("3"));
        courseDB.get("4").getEnrolledStudents().put("4", studentDB.get("4"));
        courseDB.get("5").getEnrolledStudents().put("5", studentDB.get("5"));
    }

    public List<Course> getAllCourses() {
        List<Course> courseList = new ArrayList<>();

        for (Course course : courseDB.values()) {
            courseList.add(course);
        }

        return courseList;
    }

    public Course getCourseById(String courseId) {
        Course foundCourse = courseDB.get(courseId);

        System.out.println("Course item retrieve: " + foundCourse);
        System.out.println(foundCourse.toString());

        return foundCourse;
    }

    public void addCourse(String courseName) {
        String courseId = String.valueOf(courseDB.size() + 1);

        Lecture lecture = new Lecture();
        Professor professor = new Professor();
        Student courseTA = new Student();
        Map<String, Object> roster = new HashMap<>();
        Map<String, Student> studentList = new HashMap<>();
        Set<Object> board = new HashSet<>();
        Course newCourse = new Course(
                                      courseId,
                                      courseName,
                                      lecture,
                                      professor,
                                      courseTA,
                                      roster,
                                      studentList,
                                      board);

        courseDB.put(courseId, newCourse);
    }

    public Course deleteCourse(String courseId) {
        Course deleteProgram = courseDB.get(courseId);

        courseDB.remove(courseId);
        return deleteProgram;
    }

    public Course updateProgram(String programId, Course course) {
        Course updateProgram = courseDB.get(programId);

        updateProgram.setCourseName(course.getCourseName());
        updateProgram.setProfessor(course.getProfessor());
        updateProgram.setCourseLecture(course.getCourseLecture());
        return updateProgram;
    }
}
