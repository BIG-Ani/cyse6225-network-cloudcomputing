package com.spring2020cyse6225.studinfo.util;

public class MessageUtil {

    public static String builtMessage(int statusCode) {
        String message = "";

        switch (statusCode) {
            case 1:
                message = "1 - Student registers the course successfully";
                break;
            case 2:
                message = "2 - Student have registered the course before";
                break;
            case 3:
                message = "3 - Student drop the course successfully";
                break;
            case 4:
                message = "4 - Student have not registered the course before";
                break;
            case 5:
                message = "5 - Course already has the student";
                break;
            case 6:
                message = "6 - Course add the student successfully";
                break;
            case 7:
                message = "7 - Course does not have the student";
                break;
            case 8:
                message = "8 - Course removes the student successfully";
                break;
        }

        return message;
    }

}
