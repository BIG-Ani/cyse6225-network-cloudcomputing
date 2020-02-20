package com.spring2020cyse6225.studinfo.datamodel;

import lombok.Data;

@Data
public class Professor {
    private String id;
    private String firstName;
    private String lastName;
    private String department;
    private String professorId;
    private String joiningDate;

    public Professor() {
    }

    public Professor(String id,
                     String firstName,
                     String lastName,
                     String department,
                     String professorId,
                     String joiningDate) {
        this.id = id;
        this.professorId = professorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.professorId = professorId;
        this.joiningDate = joiningDate;
    }

    @Override
    public String toString() {
        return "ProfId=" + getProfessorId() + ", firstName=" + getFirstName()
                + ", department=" + getDepartment() + ", joiningDate=" + getJoiningDate();
    }
}
