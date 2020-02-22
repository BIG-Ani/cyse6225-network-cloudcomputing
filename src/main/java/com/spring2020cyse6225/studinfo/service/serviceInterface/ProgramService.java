package com.spring2020cyse6225.studinfo.service.serviceInterface;

import com.spring2020cyse6225.studinfo.datamodel.Program;

import java.util.List;

public interface ProgramService {

    void addProgram(String program);

    void deleteProgram(String programId);

    void updateProgramInfo(String programId, Program program);

    Program findProgramById(String programId);

    List<Program> findAllPrograms();
}
