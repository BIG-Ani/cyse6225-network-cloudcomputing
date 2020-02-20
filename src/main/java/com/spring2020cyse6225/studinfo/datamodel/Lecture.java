package com.spring2020cyse6225.studinfo.datamodel;

import lombok.Data;

@Data
public class Lecture {

    private String lectureId;

    private String note;

    private String material;

    public Lecture() {
    }

    public Lecture(String lectureId,
                   String note,
                   String material) {
        this.lectureId = lectureId;
        this.note = note;
        this.material = material;
    }
}
