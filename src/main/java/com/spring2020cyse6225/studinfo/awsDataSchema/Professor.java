package com.spring2020cyse6225.studinfo.awsDataSchema;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIgnore;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="Professor")
public class Professor {
    private String firstName;
    private String lastName;
    private String department;
    private long professorId;
    private String joiningDate;

    public Professor() {

    }

    public Professor(long professorId,
                     String firstName,
                     String lastName,
                     String department,
                     String joiningDate) {
        this.professorId = professorId;
        this.firstName = firstName;
        this.firstName = lastName;
        this.department = department;
        this.joiningDate = joiningDate;
    }

    @DynamoDBAttribute(attributeName="firstName")
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @DynamoDBAttribute(attributeName = "lastName")
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @DynamoDBAttribute(attributeName="department")
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }

    @DynamoDBHashKey(attributeName="professorId")
    public long getProfessorId() {
        return professorId;
    }
    public void setProfessorId(long professorId) {
        this.professorId = professorId;
    }

    @DynamoDBAttribute(attributeName="joiningDate")
    public String getJoiningDate() {
        return joiningDate;
    }
    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }

    @DynamoDBIgnore
    @Override
    public String toString() {
        return "ProfId=" + getProfessorId() + ", firstName=" + getFirstName()
                + ", department=" + getDepartment() + ", joiningDate=" + getJoiningDate();
    }
}