package com.study.utils.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {


    private String name;
    private int old;
    public String sex;
    public static String like = "linux";


    public String getLike(){
        return like;
    }

    private void printSex() {
        System.out.println("sex: " + sex);
    }

    protected void printOld(){
        System.out.println("old: " + old);
    }


    private Person(String name, int old) {
        this(name, old, "1");
    }


    public void printNull() {
        System.out.println("null");
    }

    public void printName() {
        System.out.println("name:" + name);
    }

    public void printYear(String year) {
        System.out.println("year: " + year);
    }


    public static void printLike() {
        System.out.println("like:  " + like);
    }


}
