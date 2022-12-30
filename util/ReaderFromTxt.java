package util;

import java.util.List;

import data.User;

public class ReaderFromTxt {

    public static <U extends User> U read(U user) {
        return user;
    }

    public static <U extends User> U readTeacher() {
        return null;
    }

    public static <U> List<U> readStudents() {
        return null;
    }
}