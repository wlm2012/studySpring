package com.study.utils.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Teacher extends Person {
    private long students;
    public long clazz;

    public Teacher(String name, int old, String sex, long students) {
        setName(name);
        setOld(old);
        setSex(sex);
        this.students = students;
    }

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
