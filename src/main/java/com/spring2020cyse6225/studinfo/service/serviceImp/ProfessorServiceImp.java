package com.spring2020cyse6225.studinfo.service.serviceImp;

import com.spring2020cyse6225.studinfo.dao.ProfessorDao;
import com.spring2020cyse6225.studinfo.datamodel.Professor;
import com.spring2020cyse6225.studinfo.service.serviceInterface.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProfessorServiceImp implements ProfessorService {

    @Autowired
    ProfessorDao professorDao;

    @Override
    public void addNewProfessor(String firstName, String lastName, String department, Date joiningDate) {
        professorDao.addProfessor(
                firstName,
                lastName,
                department,
                joiningDate);

        Long profId = (long)professorDao.getAllProfessors().size();
        System.out.println(professorDao.getProfessor(String.valueOf(profId)).toString());
    }

    @Override
    public Professor deleteProfessor(Long profId) {
        return professorDao.deleteProfessor(profId);
    }

    @Override
    public void updateProfessorInfo(Long profId, Professor professor) {
        professorDao.updateProfessorInformation(String.valueOf(profId), professor);
    }

    @Override
    public Professor findProfessorById(Long profId) {
        Professor professor = professorDao.getProfessor(String.valueOf(profId));

        return professor;
    }

    @Override
    public List<Professor> findAllProfessors() {
        List<Professor> allProfessors = professorDao.getAllProfessors();

        return allProfessors;
    }

    @Override
    public List<Professor> findProfessorsByDepartment(String department) {
        List<Professor> professorsByDepartment = professorDao.getProfessorsByDepartment(department);

        return professorsByDepartment;
    }
}
