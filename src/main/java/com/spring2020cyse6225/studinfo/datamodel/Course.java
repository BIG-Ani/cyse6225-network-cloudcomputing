package com.spring2020cyse6225.studinfo.datamodel;

import lombok.Data;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Data
public class Course {

    private String courseId;

    private String courseName;

    private Lecture courseLecture;

    private Professor professor;

    private Student teachingAssistant;

    private Map<String, Object> roster = new HashMap<>();

    // key student id, value - student name
    private Map<String, String> enrolledStudents = new HashMap<>();

    private Set<Object> board = new HashSet<>();

    public Course(String courseId,
                  String courseName,
                  Lecture courseLecture,
                  Professor professor,
                  Student teachingAssistant,
                  Map<String, Object> roster,
                  Map<String, String> enrolledStudents,
                  Set<Object> board) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseLecture = courseLecture;
        this.professor = professor;
        this.teachingAssistant = teachingAssistant;
        this.roster = roster;
        this.enrolledStudents = enrolledStudents;
        this.board = board;
    }

}
