package com.study.utils.maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapT {

    public static void test() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "qqq");
        map.put(2, "ww");
        map.put(3, "ee");

        //如果key存在则执行lambda表达式
        map.merge(3, "aa", (v1, v2) -> v1 + v2);
        System.out.println(map);
        //否则赋值value
        map.merge(4, "aa", (v1, v2) -> v1 + v2);
        System.out.println(map);

        map.putIfAbsent(6, "11");
        System.out.println(map);
    }

    public static void computeIfAbsent() {
        Map<String, List<String>> result = new HashMap<>();
        result.computeIfAbsent("1", key -> new ArrayList<>())
                .add("a".trim());
        result.computeIfAbsent("1", key -> new ArrayList<>())
                .add("a");
        System.out.println(result);
    }
}
