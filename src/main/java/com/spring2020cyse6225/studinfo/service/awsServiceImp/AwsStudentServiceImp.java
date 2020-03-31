package com.spring2020cyse6225.studinfo.service.awsServiceImp;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.spring2020cyse6225.studinfo.awsDataSchema.DynamoDbConnector;
import com.spring2020cyse6225.studinfo.awsDataSchema.Student;
import com.spring2020cyse6225.studinfo.service.awsServiceInterface.AwsStudentServiceInterface;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Set;

@Service
public class AwsStudentServiceImp implements AwsStudentServiceInterface {

    private static DynamoDbConnector dynamoDb;
    private DynamoDBMapper studentMapper;

    public AwsStudentServiceImp() {
        dynamoDb = new DynamoDbConnector();
        dynamoDb.init();

        studentMapper = new DynamoDBMapper(dynamoDb.getClient());
    }

    @Override
    public Student addStudent(Student student) {
        if (student == null) {
            System.out.println("Please add valid student information");

            return null;
        } else {
            System.out.println("Add new student >> \n" + student);
            studentMapper.save(student);

            return student;
        }
    }

    @Override
    public Student deleteStudent(Long studentId) {
        Student deleteStudent = studentMapper.load(Student.class, studentId);

        if (deleteStudent == null) {
            System.out.println("Delete student >>\n" + "Student does not exist!");
        } else {
            studentMapper.delete(deleteStudent);
            System.out.println("Delete student >>\n" +
                    "Student " + studentId + " has been deleted!");

            return deleteStudent;
        }

        return null;
    }

    @Override
    public Student updateStudent(Long studentId, Student student) {

        Student foundStudent = studentMapper.load(Student.class, studentId);

        if (foundStudent == null) {
            System.out.println("The student intended to update does not exist!");
            return null;
        } else {
            Long newStudentId = student.getStudentId();
            String firstName = student.getFirstName();
            String lastName = student.getLastName();
            String department = student.getDepartment();
            Date joinDate = student.getJoinDate();
//            Set<Object> registeredCourses = student.getRegisteredCourses();

            if (newStudentId != null) {
                foundStudent.setStudentId(newStudentId);
            }

            if (firstName != null) {
                foundStudent.setFirstName(firstName);
            }

            if (lastName != null) {
                foundStudent.setLastName(lastName);
            }

            if (department != null) {
                foundStudent.setDepartment(department);
            }

//            if (registeredCourses != null) {
//                foundStudent.setRegisteredCourses(registeredCourses);
//            }

            return foundStudent;
        }
    }

    @Override
    public Student findStudentById(Long studentId) {
        Student foundStudent = studentMapper.load(Student.class, studentId);

        if (foundStudent == null) {
            System.out.println("Student intended to find does not exist!");

            return null;
        } else {
            System.out.println("Find student >>\n" + foundStudent);

            return foundStudent;
        }
    }
}
