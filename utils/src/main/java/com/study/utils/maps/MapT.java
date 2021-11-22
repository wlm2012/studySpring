package com.study.utils.maps;

import java.util.HashMap;
import java.util.Map;

public class MapT {

    public static void test() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "qqq");
        map.put(2, "ww");
        map.put(3, "ee");

        map.merge(3, "aa", (v1, v2) -> v1 + v2);
        System.out.println(map);
        map.merge(4, "aa", (v1, v2) -> v1 + v2);
        System.out.println(map);

    }
}
