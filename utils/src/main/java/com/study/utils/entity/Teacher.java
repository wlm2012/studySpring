package com.study.utils.entity;

public class Teacher extends Person {
    private long students;

    public long getStudents() {
        return students;
    }

    private void setStudents(long size) {
        students = size;
    }

    protected static long getClazz(long clazz) {
        return 1 + clazz;
    }

}
