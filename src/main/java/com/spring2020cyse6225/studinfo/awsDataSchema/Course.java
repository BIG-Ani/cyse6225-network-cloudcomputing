package com.spring2020cyse6225.studinfo.awsDataSchema;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.Set;

@DynamoDBTable(tableName = "Course")
public class Course {

    /*
    * Course
     - Id (Dynamo Db generated) and hash key
     - courseId - DynamoDbIndexHashKey, a Global Secondary Index (GSI)
     - professorId
     - taId
     - department
     - boardId
     - listOfRegisteredStudents/roster - has student Id list (this is the roster)
    * */

    private Long courseId;

    private Long professorId;

    private Long taId;

    private String courseName;

    private String department;

    private Long boardId;

    private Set<Integer> registeredStudents;

    public Course() {
    }

    public Course(/*Long Id,*/
                  Long courseId,
                  Long professorId,
                  Long taId,
                  String courseName,
                  String department,
                  Long boardId,
                  Set<Integer> registeredStudents) {
//        this.Id = Id;
        this.courseId = courseId;
        this.professorId = professorId;
        this.taId = taId;
        this.courseName = courseName;
        this.department = department;
        this.boardId = boardId;
        this.registeredStudents = registeredStudents;
    }

    /*
    @DynamoDBAttribute(attributeName = "Id")
    @DynamoDBAutoGeneratedKey
    public Long getId() {
        return Id;
    }
    public void setId(Long id) {
        Id = id;
    }
     */

    @DynamoDBHashKey(attributeName = "courseId")
    public Long getCourseId() {
        return courseId;
    }
    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    @DynamoDBAttribute(attributeName = "professorId")
    public Long getProfessorId() {
        return professorId;
    }
    public void setProfessorId(Long professorId) {
        this.professorId = professorId;
    }

    @DynamoDBAttribute(attributeName = "taId")
    public Long getTaId() {
        return taId;
    }
    public void setTaId(Long taId) {
        this.taId = taId;
    }

    @DynamoDBAttribute(attributeName = "courseName")
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @DynamoDBAttribute(attributeName = "department")
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }

    @DynamoDBAttribute(attributeName = "boardId")
    public Long getBoardId() {
        return boardId;
    }
    public void setBoardId(Long boardId) {
        this.boardId = boardId;
    }

    @DynamoDBAttribute(attributeName = "registeredStudents")
    public Set<Integer> getRegisteredStudents() {
        return registeredStudents;
    }
    public void setRegisteredStudents(Set<Integer> registeredStudents) {
        this.registeredStudents = registeredStudents;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", professorId=" + professorId +
                ", taId=" + taId +
                ", courseName='" + courseName + '\'' +
                ", department='" + department + '\'' +
                ", boardId=" + boardId +
                ", registeredStudents=" + registeredStudents +
                '}';
    }
}
