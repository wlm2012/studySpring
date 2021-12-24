package com.study.utils.entityEnum;

public enum Inquired {
    XCX("需查询", 1), YCX("已查询", 2), BXCX("不需查询", 0);

    private String descript;
    private int value;

    Inquired(String descript, int value) {
        this.descript = descript;
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return descript;
    }
}
