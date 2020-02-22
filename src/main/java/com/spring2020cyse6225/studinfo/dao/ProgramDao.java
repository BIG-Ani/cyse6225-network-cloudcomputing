package com.spring2020cyse6225.studinfo.dao;

import com.spring2020cyse6225.studinfo.dataSource.InMemoryDatabase;
import com.spring2020cyse6225.studinfo.datamodel.Course;
import com.spring2020cyse6225.studinfo.datamodel.Professor;
import com.spring2020cyse6225.studinfo.datamodel.Program;
import com.spring2020cyse6225.studinfo.datamodel.Student;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class ProgramDao {

    private static Map<String, Program> programDB = InMemoryDatabase.getProgramDB();
    private static Map<String, Course> courseDB = InMemoryDatabase.getCourseDB();
    private static Map<String, Student> studentDB = InMemoryDatabase.getStudentDB();
    private static Map<Long, Professor> professorDB = InMemoryDatabase.getProfessorDB();

    public ProgramDao() {
        init();
    }

    private static void init() {
        programDB.get("1")
                .getCurriculum()
                .put(
                        courseDB.get("1").getCourseId(),
                        courseDB.get("1")
                );

        programDB.get("1")
                .getCurriculum()
                .put(
                        courseDB.get("3").getCourseId(),
                        courseDB.get("3")
                );

        programDB.get("1")
                .getCurriculum()
                .put(
                        courseDB.get("5").getCourseId(),
                        courseDB.get("5")
                );

        programDB.get("2")
                .getCurriculum()
                .put(
                        courseDB.get("2").getCourseId(),
                        courseDB.get("2")
                );

        programDB.get("2")
                .getCurriculum()
                .put(
                        courseDB.get("4").getCourseId(),
                        courseDB.get("4")
                );
    }

    public List<Program> getAllPrograms() {
        List<Program> programList = new ArrayList<>();

        for (Program program : programDB.values()) {
            programList.add(program);
        }

        return programList;
    }

    public Program getProgramById(String programId) {
        Program foundProgram = programDB.get(programId);

        System.out.println("Program item retrieve:\n" + foundProgram);

        return foundProgram;
    }

    public void addProgram(String programName) {
        String programId = String.valueOf(programDB.size() + 1);

        Program newProgram = new Program(programId, programName);
        programDB.put(programId, newProgram);
    }

    public Program deleteProgram(String programId) {
        Program deleteProgram = programDB.get(programId);

        programDB.remove(programId);
        return deleteProgram;
    }

    public Program updateProgram(String programId, Program program) {
        Program updateProgram = programDB.get(programId);

        updateProgram.setProgramName(program.getProgramName());
        return updateProgram;
    }
}
