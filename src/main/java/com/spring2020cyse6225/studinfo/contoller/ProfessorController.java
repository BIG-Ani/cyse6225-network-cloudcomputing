package com.spring2020cyse6225.studinfo.contoller;

//import com.spring2020cyse6225.studinfo.datamodel.Professor;
import com.spring2020cyse6225.studinfo.awsDataSchema.Professor;
import com.spring2020cyse6225.studinfo.service.awsServiceImp.AwsProfessorServiceImp;
import com.spring2020cyse6225.studinfo.service.serviceImp.ProfessorServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class ProfessorController {

    @Autowired
    ProfessorServiceImp profService;

    @Autowired
    AwsProfessorServiceImp awsProfessorService;

//    @GetMapping("/professors")
//    public List<Professor> getProfessors() {
//        return profService.findAllProfessors();
//    }

//    @GetMapping("/professors/department")
//    public List<Professor> getProfessorsByDeparment(
//            @RequestParam(value = "department", defaultValue = "INFO") String department) {
//        System.out.println(this.getClass().getName() + ".getProfessorsByDeparment:" + department);
//
//        if (department == null) {
//            return profService.findAllProfessors();
//        }
//
//        return profService.findProfessorsByDepartment(department);
//    }

    @GetMapping("/professor/{profId}")
    public Professor getProfessor(@PathVariable String profId) {
//        System.out.println("Professor Resource: Looking for: " + profId);
//        return profService.findProfessorById(Long.parseLong(profId));

        Professor professor = awsProfessorService.findProfessorById(Long.parseLong(profId));
        return professor;
    }

    @DeleteMapping("/professor/{professorId}")
    public Professor deleteProfessor(@PathVariable("professorId") long profId) {
//        return profService.deleteProfessor(profId);

        Professor deleteProf = awsProfessorService.deleteProfessorById(profId);

        return deleteProf;
    }
    
    @PostMapping("/professor")
    public Professor addProfessor(Professor prof) {
//        profService.addNewProfessor(prof.getFirstName(),
//                                 prof.getLastName(),
//                                 prof.getDepartment(),
//                                 new Date());
//
//        Long profId = (long)profService.findAllProfessors().size();
//        return profService.findProfessorById(profId);

        Professor addProfessor = awsProfessorService.addProfessor(prof);

        return addProfessor;
    }

    @PutMapping("/professor/{professorId}")
    public Professor updateProfessor(@PathVariable("professorId") String profId,
                                     Professor prof) {
//        profService.updateProfessorInfo(Long.parseLong(profId), prof);
//
//        return profService.findProfessorById(Long.parseLong(profId));

        Professor updateProfessor = awsProfessorService.updateProfessor(Long.parseLong(profId), prof);

        return updateProfessor;
    }
}