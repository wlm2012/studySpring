package com.study.utils.functional.chapter6;

import java.util.List;

public class BuggyReduce {

    public static int multiplyThroughBug(List<Integer> linkedListOfNumbers) {
        //375000
        return linkedListOfNumbers.stream().parallel()
                .reduce(5, (acc, x) -> x * acc, (acc, x) -> acc * x);
    }


    public static int multiplyThrough(List<Integer> integers) {
        //600
        return 5 * integers.parallelStream()
                .reduce(1, (acc, x) -> x * acc);
    }
}
