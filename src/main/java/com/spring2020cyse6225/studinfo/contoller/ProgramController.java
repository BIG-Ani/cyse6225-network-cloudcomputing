package com.spring2020cyse6225.studinfo.contoller;

import com.spring2020cyse6225.studinfo.datamodel.Program;
import com.spring2020cyse6225.studinfo.service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProgramController {

    @Autowired
    ProgramService programService;

    /**
     * @Description: localhost:8080/programs
     * @Time: 2/19/20
    **/ 
    @GetMapping("/programs")
    public List<Program> getPrograms() {
        List<Program> programList = programService.getAllPrograms();

        return programList;
    }

    /**
     * @Description: localhost:8080/program/1
     * @Time: 2/19/20
    **/ 
    @GetMapping("/program/{programId}")
    public Program getProgramById(@PathVariable(value = "programId") String programId) {
        Program foundProgram = programService.getProgramById(programId);

        return foundProgram;
    }

    /**
     * @Description: localhost:8080/program
     * @Params: post
     * @Time: 2/19/20
    **/
    @PostMapping("/program")
    public Program addProgram(Program program) {
        programService.addProgram(program.getProgramName());

        return programService.getProgramById(String.valueOf(programService.getAllPrograms().size()));
    }

    @PutMapping("/program/{programId}")
    public Program updateProgram(@PathVariable String programId,
                                 Program program) {
        Program updateProgram = programService.updateProgram(programId, program);

        return updateProgram;
    }

    /**
     * @Description: localhost:8080/program/3
     * @Params: delete
     * @Time: 2/19/20
    **/
    @DeleteMapping("/program/{programId}")
    public Program deleteProgram(@PathVariable String programId) {
        Program deleteProgram = programService.getProgramById(programId);

        programService.deleteProgram(programId);
        return deleteProgram;
    }
}
