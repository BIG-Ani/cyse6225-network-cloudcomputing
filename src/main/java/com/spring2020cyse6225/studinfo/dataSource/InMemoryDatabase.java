package com.spring2020cyse6225.studinfo.dataSource;

import com.spring2020cyse6225.studinfo.datamodel.*;

import java.util.HashMap;
import java.util.HashSet;

public class InMemoryDatabase {

    private static HashMap<Long, Professor> professorDB = new HashMap<>();

    private static HashMap<String, Course> courseDB = new HashMap<>();

    private static HashMap<String, Student> studentDB = new HashMap<>();

    private static HashMap<String, Program> programDB = new HashMap<>();

    public static HashMap<String, Student> getStudentDB() {
        studentDB.put("1", new Student("1", "studentA", "/image/studentA", "programA", new HashMap<>()));
        studentDB.put("2", new Student("2", "studentB", "/image/studentB", "programA", new HashMap<>()));
        studentDB.put("3", new Student("3", "studentC", "/image/studentC", "programA", new HashMap<>()));
        studentDB.put("4", new Student("4", "studentD", "/image/studentD", "programA", new HashMap<>()));
        studentDB.put("5", new Student("5", "studentE", "/image/studentE", "programB", new HashMap<>()));
        studentDB.put("6", new Student("6", "studentF", "/image/studentF", "programB", new HashMap<>()));
        studentDB.put("7", new Student("7", "studentG", "/image/studentG", "programB", new HashMap<>()));

        return studentDB;
    }

    public static HashMap<String, Course> getCourseDB() {
        Lecture lecture1 = new Lecture("1", "note1", "material1");
        Lecture lecture2 = new Lecture("2", "note2", "material2");
        Lecture lecture3 = new Lecture("3", "note3", "material3");
        Lecture lecture4 = new Lecture("4", "note4", "material4");
        Lecture lecture5 = new Lecture("5", "note5", "material5");

        courseDB.put("1", new Course("1", "courseA", lecture1,
                professorDB.get(1), studentDB.get("1"),
                new HashMap<>(), new HashMap<>(), new HashSet<>()));

        courseDB.put("2", new Course("2", "courseB", lecture2,
                professorDB.get(2), studentDB.get("2"),
                new HashMap<>(), new HashMap<>(), new HashSet<>()));

        courseDB.put("3", new Course("3", "courseC", lecture3,
                professorDB.get(3), studentDB.get("3"),
                new HashMap<>(), new HashMap<>(), new HashSet<>()));

        courseDB.put("4", new Course("4", "courseD", lecture4,
                professorDB.get(4), studentDB.get("4"),
                new HashMap<>(), new HashMap<>(), new HashSet<>()));

        courseDB.put("5", new Course("5", "courseE", lecture5,
                professorDB.get(5), studentDB.get("5"),
                new HashMap<>(), new HashMap<>(), new HashSet<>()));

        return courseDB;
    }

    public static HashMap<Long, Professor> getProfessorDB() {
        professorDB.put((long) 1, new Professor("1", "Professor", "A", "INFO", "1", "2020-01-01"));
        professorDB.put((long) 2, new Professor("2", "Professor", "B", "INFO", "2", "2020-02-01"));
        professorDB.put((long) 3, new Professor("3", "Professor", "C", "CYSE", "3", "2020-01-02"));
        professorDB.put((long) 4, new Professor("4", "Professor", "D", "COOP", "4", "2020-11-01"));
        professorDB.put((long) 5, new Professor("5", "Professor", "E", "INFO", "5", "2020-03-01"));

        return professorDB;
    }

    public static HashMap<String, Program> getProgramDB() {
        programDB.put("1", new Program("1", "programA"));
        programDB.put("2", new Program("2", "programB"));

        programDB.get("1").setCurriculum(new HashMap<>());
        programDB.get("2").setCurriculum(new HashMap<>());

        return programDB;
    }

}
