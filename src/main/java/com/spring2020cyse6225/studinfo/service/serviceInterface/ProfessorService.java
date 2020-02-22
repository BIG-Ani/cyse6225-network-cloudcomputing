package com.spring2020cyse6225.studinfo.service.serviceInterface;

import com.spring2020cyse6225.studinfo.datamodel.Professor;

import java.util.Date;
import java.util.List;

public interface ProfessorService {

    void addNewProfessor(String firstName, String lastName, String department, Date joiningDate);

    Professor deleteProfessor(Long profId);

    void updateProfessorInfo(Long profId, Professor professor);

    Professor findProfessorById(Long profId);

    List<Professor> findAllProfessors();

    List<Professor> findProfessorsByDepartment(String Department);
}
