package com.study.utils.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
public class Teacher extends Person {
    private long students;
    public long clazz;
    private Map<Integer, String> score;

    public Map<Integer, String> getScore(Map<Integer, String> map, List<Integer> list) {
        return map;
    }

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
