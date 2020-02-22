package com.spring2020cyse6225.studinfo.status;

public enum StudentOptResCode {

    /* student operation */
    STUDENT_ADD_COURSE_SUCCESS(1),
    STUDENT_ADD_COURSE_ALREADY(2),
    STUDENT_RM_COURSE_SUCCESS(3),
    STUDENT_RM_COURSE_ALREADY(4),

    /* course register */
    COURSE_REG_ALREADY_REG(5),
    COURSE_ADD_STUDENT_SUCCESS(6),
    COURSE_RM_ALREADY_RM(7),
    COURSE_RM_STUDENT_SUCCESS(8);

    public final int statusCode;

    StudentOptResCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
