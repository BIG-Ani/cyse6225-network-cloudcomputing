package com.spring2020cyse6225.studinfo.service.serviceImp;

import com.spring2020cyse6225.studinfo.dao.ProgramDao;
import com.spring2020cyse6225.studinfo.datamodel.Program;
import com.spring2020cyse6225.studinfo.service.serviceInterface.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramServiceImp implements ProgramService {

    @Autowired
    ProgramDao programDao;

    @Override
    public void addProgram(String program) {
        programDao.addProgram(program);

        String programId = String.valueOf(programDao.getAllPrograms().size());
        String newProgram = programDao.getProgramById(programId).toString();

        System.out.println("new program>>>\n" + newProgram);
    }

    @Override
    public void deleteProgram(String programId) {
        Program deleteProgram = programDao.deleteProgram(programId);

        System.out.println(deleteProgram.toString());
    }

    @Override
    public void updateProgramInfo(String programId, Program program) {
        programDao.updateProgram(programId, program);
    }

    @Override
    public Program findProgramById(String programId) {
        Program foundProgram = programDao.getProgramById(programId);

        return foundProgram;
    }

    @Override
    public List<Program> findAllPrograms() {
        List<Program> allPrograms = programDao.getAllPrograms();

        return allPrograms;
    }
}
