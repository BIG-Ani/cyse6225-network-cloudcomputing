package com.spring2020cyse6225.studinfo.contoller;

import com.spring2020cyse6225.studinfo.datamodel.Program;
import com.spring2020cyse6225.studinfo.service.serviceImp.ProgramServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProgramController {

    @Autowired
    ProgramServiceImp programService;

    @GetMapping("/programs")
    public List<Program> getPrograms() {
        List<Program> programList = programService.findAllPrograms();

        return programList;
    }

    @GetMapping("/program/{programId}")
    public Program getProgramById(@PathVariable(value = "programId") String programId) {
        Program foundProgram = programService.findProgramById(programId);

        return foundProgram;
    }

    @PostMapping("/program")
    public Program addProgram(Program program) {
        programService.addProgram(program.getProgramName());
        String newProgramId = String.valueOf(programService.findAllPrograms().size());

        return programService.findProgramById(newProgramId);
    }

    @PutMapping("/program/{programId}")
    public Program updateProgram(@PathVariable String programId,
                                 Program program) {
        programService.updateProgramInfo(programId, program);

        return programService.findProgramById(programId);
    }

    @DeleteMapping("/program/{programId}")
    public Program deleteProgram(@PathVariable String programId) {
        Program deleteProgram = programService.findProgramById(programId);

        programService.deleteProgram(programId);
        return deleteProgram;
    }
}
