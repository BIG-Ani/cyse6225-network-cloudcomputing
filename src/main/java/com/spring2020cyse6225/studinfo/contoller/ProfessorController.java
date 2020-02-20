package com.spring2020cyse6225.studinfo.contoller;

import com.spring2020cyse6225.studinfo.datamodel.Professor;
import com.spring2020cyse6225.studinfo.service.ProfessorService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Date;
import java.util.List;

@RestController
public class ProfessorController {

    ProfessorService profService = new ProfessorService();

    /**
     * @Description: localhost:8080/professors == method=get
     * @Params: null
     * @Return: professor list
     * @Time: 2/19/20
    **/
    @GetMapping("/professors")
    public List<Professor> getProfessors() {
        return profService.getAllProfessors();
    }

    /**
     * @Description: localhost:8080/professors/department?department=INFO
     * @Params: department
     * @Return: professors in this department
     * @Time: 2/19/20
    **/
    @GetMapping("/professors/department")
    public List<Professor> getProfessorsByDeparment(
            @RequestParam(value = "department", defaultValue = "INFO") String department) {
        System.out.println(this.getClass().getName() + ".getProfessorsByDeparment:" + department);

        if (department == null) {
            return profService.getAllProfessors();
        }

        return profService.getProfessorsByDepartment(department);
    }

    /**
     * @Description: localhost:8080/professor/101 >> method=get
     * @Params: professor id
     * @Return: the found professor
     * @Time: 2/19/20
    **/
    @GetMapping("/professor/{profId}")
    public Professor getProfessor(@PathVariable String profId) {
        System.out.println("Professor Resource: Looking for: " + profId);
        return profService.getProfessor(profId);
    }

    /**
     * @Description: localhost:8080/professors/101 >> method=delete
     * @Params: professorId
     * @Return: Professor
     * @Time: 2/19/20
    **/
    @DeleteMapping("/professors/{professorId}")
    public Professor deleteProfessor(@PathVariable("professorId") long profId) {
        return profService.deleteProfessor(profId);
    }
    
    /**
     * @Description: localhost:8080/professor >> method=post formbody={FirstName, LastName, Department, Date}
     * @Params: Professor
     * @Return: Added Professor
     * @Time: 2/19/20
    **/ 
    @PostMapping("/professor")
    public Professor addProfessor(Professor prof) {
        profService.addProfessor(prof.getFirstName(),
                                 prof.getLastName(),
                                 prof.getDepartment(),
                                 new Date());

        return profService.getProfessor("" + profService.getAllProfessors().size());
    }

    /**
     * @Description: localhost:8080/professor/1 >> method=put
     * @Params: professor id
     * @Return: updated professor
     * @Time: 2/19/20
    **/ 
    @PutMapping("/professor/{professorId}")
    public Professor updateProfessor(@PathVariable("professorId") String profId,
                                     Professor prof) {
        return profService.updateProfessorInformation(profId, prof);
    }

//    @PostMapping("/professor")
//    public void addProfessor(String firstName, String lastName, String department, Date joiningDate) {
//        profService.addProfessor(firstName, lastName, department, joiningDate);
//    }
}