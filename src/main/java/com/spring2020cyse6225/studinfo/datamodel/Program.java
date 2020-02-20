package com.spring2020cyse6225.studinfo.datamodel;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Program {

    private String programId;

    private String programName;

    private Map<String, Course> curriculum = new HashMap<>();

    public Program(String programId, String programName) {
        this.programId = programId;
        this.programName = programName;
    }
}
