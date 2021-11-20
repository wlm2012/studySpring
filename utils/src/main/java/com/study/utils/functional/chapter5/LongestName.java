package com.study.utils.functional.chapter5;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LongestName {

    public static String byCollecting(Stream<String> names) {

        return names.collect(Collectors.maxBy(Comparator.comparing(String::length)))
                .orElseThrow(RuntimeException::new);
    }

    public static String byMax(Stream<String> names) {

        return names.max(Comparator.comparing(String::length))
                .orElseThrow(RuntimeException::new);
    }

    public static String byReduce(Stream<String> names) {
        return names.reduce((acc, x) -> acc.length() > x.length() ? acc : x).orElseThrow(RuntimeException::new);
    }


}
