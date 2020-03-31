package com.spring2020cyse6225.studinfo.service.awsServiceImp;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.spring2020cyse6225.studinfo.awsDataSchema.DynamoDbConnector;
import com.spring2020cyse6225.studinfo.awsDataSchema.Professor;
import com.spring2020cyse6225.studinfo.service.awsServiceInterface.AwsProfessorServiceInterface;
import org.springframework.stereotype.Service;

@Service
public class AwsProfessorServiceImp implements AwsProfessorServiceInterface {

    private static DynamoDbConnector dynamoDb;
    private DynamoDBMapper professorMapper;

    public AwsProfessorServiceImp() {
        dynamoDb = new DynamoDbConnector();
        dynamoDb.init();

        professorMapper = new DynamoDBMapper(dynamoDb.getClient());
    }

    @Override
    public Professor addProfessor(Professor professor) {
        if (professor == null) {
            System.out.println("Please input valid professor information");

            return null;
        } else {
            System.out.println("Add new professor >>\n" + professor);

            return professor;
        }
    }

    @Override
    public Professor deleteProfessorById(Long professorId) {
        Professor deleteProfessor = professorMapper.load(Professor.class, professorId);

        if (deleteProfessor == null) {
            System.out.println("The professor does not exist!");

            return null;
        } else {
            long profId = deleteProfessor.getProfessorId();

            System.out.println("Deleting professor >> \n" + "Prof. " + profId + " has been deleted!");

            professorMapper.delete(deleteProfessor);
        }

        return null;
    }

    @Override
    public Professor updateProfessor(Long professorId, Professor newProfessor) {

        Professor foundProfessor = professorMapper.load(Professor.class, professorId);

        if (foundProfessor == null) {
            System.out.println("Professor intended to update does not exist!");
            return null;
        } else {
            Long newProfessorId = foundProfessor.getProfessorId();
            String firstName = foundProfessor.getFirstName();
            String lastName = foundProfessor.getLastName();
            String department = foundProfessor.getDepartment();
            String joiningDate = foundProfessor.getJoiningDate();

            if (newProfessorId != null) {
                foundProfessor.setProfessorId(newProfessorId);
            }

            if (firstName != null) {
                foundProfessor.setFirstName(firstName);
            }

            if (lastName != null) {
                foundProfessor.setLastName(lastName);
            }

            if (department != null) {
                foundProfessor.setDepartment(department);
            }

            if (joiningDate != null) {
                foundProfessor.setJoiningDate(joiningDate);
            }

            return foundProfessor;
        }
    }

    @Override
    public Professor findProfessorById(Long professorId) {
        Professor foundProfessor = professorMapper.load(Professor.class, professorId);

        if (foundProfessor == null) {
            System.out.println("The professor intended to find does not exist!");
            return null;
        } else {
            System.out.println("Find professor >>\n" + foundProfessor);

            return foundProfessor;
        }
    }
}
