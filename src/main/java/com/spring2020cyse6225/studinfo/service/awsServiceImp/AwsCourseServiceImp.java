package com.spring2020cyse6225.studinfo.service.awsServiceImp;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.spring2020cyse6225.studinfo.awsDataSchema.Course;
import com.spring2020cyse6225.studinfo.awsDataSchema.DynamoDbConnector;
import com.spring2020cyse6225.studinfo.service.awsServiceInterface.AwsCourseServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class AwsCourseServiceImp implements AwsCourseServiceInterface {

    private static DynamoDbConnector dynamoDb;
    private DynamoDBMapper courseMapper;

    public AwsCourseServiceImp() {
        dynamoDb = new DynamoDbConnector();
        dynamoDb.init();

        courseMapper = new DynamoDBMapper(dynamoDb.getClient());
    }

    @Override
    public Course addCourse(Course course) {
        if (course == null) {
            System.out.println("adding a course with no content.");
            return null;
        } else {
            courseMapper.save(course);
            System.out.println("adding a new course successfully");

            return course;
        }
    }

    @Override
    public Course deleteCourse(Long courseId) {
        Course courseItem = courseMapper.load(Course.class, courseId);

        if (courseItem != null) {
            courseMapper.delete(courseItem);

            String courseName = courseItem.getCourseName();
            System.out.println(courseName + "has been deleted successfully!");

            return courseItem;
        } else {
            System.out.println("Delete course >> \n" + "The course does not exist!");
            return null;
        }

    }

    @Override
    public Course updateCourse(Long courseId, Course newCourse) {
        Course foundCourse = courseMapper.load(Course.class, courseId);

        if (foundCourse == null) {
            System.out.println("The course intended to update does not exist!");
            return null;
        } else {
            Long newCourseId = newCourse.getCourseId();
            String newCourseName = newCourse.getCourseName();
            String newDepartment = newCourse.getDepartment();
            Long newProfessorId = newCourse.getProfessorId();
            Long newTaId = newCourse.getTaId();
            Long newBoardId = newCourse.getBoardId();
//            Set<Object> registeredStudents = newCourse.getRegisteredStudents();

            deleteCourse(foundCourse.getCourseId());
            if (newCourseId != null) {
                foundCourse.setCourseId(newCourseId);
            }

            if (newCourseName != null) {
                foundCourse.setCourseName(newCourseName);
            }

            if (newDepartment != null) {
                foundCourse.setDepartment(newDepartment);
            }

            if (newProfessorId != null) {
                foundCourse.setProfessorId(newProfessorId);
            }

            if(newTaId != null) {
                foundCourse.setTaId(newTaId);
            }

            if (newBoardId != null) {
                foundCourse.setBoardId(newBoardId);
            }

//            if (registeredStudents != null) {
//                updatedCourse.setRegisteredStudents(registeredStudents);
//            }

            courseMapper.save(foundCourse);
            System.out.println("update course >> \n" + foundCourse);

            return foundCourse;
        }

    }

    @Override
    public Course findCourseById(Long courseId) {
        Course foundCourse = courseMapper.load(Course.class, courseId);

        if (foundCourse == null) {
            System.out.println("The course does not exist!");
            return null;
        } else {
            System.out.println("Find the course with id >> \n" + foundCourse);
            return foundCourse;
        }

    }

    @Override
    public List<Course> findAllCourses() {
        return null;
    }
}
