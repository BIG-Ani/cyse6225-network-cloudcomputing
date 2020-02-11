package com.spring2020cyse6225.studinfo.resource;

import com.spring2020cyse6225.studinfo.datamodel.Professor;
import com.spring2020cyse6225.studinfo.service.ProfessorService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Date;
import java.util.List;

@RestController
public class ProfessorResource {

    ProfessorService profService = new ProfessorService();

    @GetMapping("/professors")
    public List<Professor> getProfessors() {
        return profService.getAllProfessors();
    }

    @GetMapping("/professors/{department}")
    public List<Professor> getProfessorsByDeparment(@PathVariable("department") String department) {

        if (department == null) {
            return profService.getAllProfessors();
        }

        return profService.getProfessorsByDepartment(department);
    }

    // ... webapi/professor/1
    @GetMapping("/professor/{profId}")
    public Professor getProfessor(@PathVariable String profId) {
        System.out.println("Professor Resource: Looking for: " + profId);
        return profService.getProfessor(profId);
    }

//    @DELETE
//    @Path("/{professorId}")
//    @Produces(MediaType.APPLICATION_JSON)
    @DeleteMapping("/professors/{professorId}")
    public Professor deleteProfessor(@PathVariable("professorId") long profId) {
        return profService.deleteProfessor(profId);
    }

//    @POST
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Professor addProfessor(Professor prof) {
//        prof.setProfessorId(prof.getFirstName()+prof.getLastName());
//        prof.setJoiningDate(new Date().toString());
//        //prof.setId(prof.getProfessorId());
//        return profService.addProfessor(prof);
//    }

//    @PUT
//    @Path("/{professorId}")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
    @PutMapping("/professors/{professorId}")
    public Professor updateProfessor(@PathVariable("professorId") String profId,
                                     Professor prof) {
        return profService.updateProfessorInformation(profId, prof);
    }

    @PostMapping("/professor")
    public void addProfessor(String firstName, String lastName, String department, Date joiningDate) {
        profService.addProfessor(firstName, lastName, department, joiningDate);
    }
}
