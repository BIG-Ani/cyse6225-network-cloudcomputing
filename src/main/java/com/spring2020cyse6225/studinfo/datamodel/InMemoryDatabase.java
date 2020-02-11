package com.spring2020cyse6225.studinfo.datamodel;

import java.util.HashMap;

public class InMemoryDatabase {

    private static HashMap<Long, Professor> professorDB = new HashMap<> ();

    public static HashMap<Long, Professor> getProfessorDB() {
        professorDB.put((long) 1, new Professor("1", "zhou", "is", "12"));
        professorDB.put((long) 2, new Professor("2", "lei", "cs", "23"));
        professorDB.put((long) 3, new Professor("3", "chen", "dae", "34"));
        professorDB.put((long) 4, new Professor("4", "ma", "pm", "45"));
        return professorDB;
    }
}
