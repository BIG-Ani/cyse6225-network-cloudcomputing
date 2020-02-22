package com.spring2020cyse6225.studinfo.datamodel;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Student {

    private String studentId;

    private String studentName;

    private String image;

    private String programName;

    // key: courseId, value: courseName
    private Map<String, String> courseList = new HashMap<>();

    public Student() {
    }

    public Student(String studentId,
                   String studentName,
                   String image,
                   String programName,
                   Map<String, String> courseList
                   ) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.image = image;
        this.programName = programName;
        this.courseList = courseList;
    }
}
