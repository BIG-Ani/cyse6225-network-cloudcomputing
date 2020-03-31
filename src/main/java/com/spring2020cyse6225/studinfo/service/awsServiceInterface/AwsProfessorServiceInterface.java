package com.spring2020cyse6225.studinfo.service.awsServiceInterface;

import com.spring2020cyse6225.studinfo.awsDataSchema.Professor;

public interface AwsProfessorServiceInterface {

    Professor addProfessor(Professor professor);

    Professor deleteProfessorById(Long professorId);

    Professor updateProfessor(Long professorId, Professor newProfessor);

    Professor findProfessorById(Long professorId);

}
