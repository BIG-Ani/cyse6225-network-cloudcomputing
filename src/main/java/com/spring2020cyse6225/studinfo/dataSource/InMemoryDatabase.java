package com.spring2020cyse6225.studinfo.dataSource;

import com.spring2020cyse6225.studinfo.datamodel.Professor;

import java.util.HashMap;

public class InMemoryDatabase {

    private static HashMap<Long, Professor> professorDB = new HashMap<> ();

    public static HashMap<Long, Professor> getProfessorDB() {
        professorDB.put((long) 1, new Professor("1", "lei", "zhou", "INFO","1", "2020-01-01"));
        professorDB.put((long) 2, new Professor("2", "chen", "lei", "INFO", "2", "2020-02-01"));
        professorDB.put((long) 3, new Professor("3", "kunming", "zhang", "CYSE", "3", "2020-01-02"));
        professorDB.put((long) 4, new Professor("4", "kual", "kelsey", "COOP", "4", "2020-11-01"));
        professorDB.put((long) 5, new Professor("5", "kai", "tian", "INFO", "5", "2020-03-01"));

        return professorDB;
    }
}
