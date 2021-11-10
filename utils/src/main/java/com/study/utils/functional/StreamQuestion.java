package com.study.utils.functional;

import java.util.List;

public class StreamQuestion {

    public static int addUp(List<Integer> list) {
        return list.stream().reduce(0, (acc, x) -> acc + x);
    }
}
