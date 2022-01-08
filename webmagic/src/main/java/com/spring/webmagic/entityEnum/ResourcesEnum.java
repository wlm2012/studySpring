package com.spring.webmagic.entityEnum;

public enum ResourcesEnum {
    av("色情片", 0), video("电影", 1),
    clazz("课程", 2), music("音乐", 3),
    book("书籍", 4);

    private String descript;
    private int value;

    ResourcesEnum(String descript, int value) {
    }

    public String getDescript() {
        return descript;
    }

    public int getValue() {
        return value;
    }
}
