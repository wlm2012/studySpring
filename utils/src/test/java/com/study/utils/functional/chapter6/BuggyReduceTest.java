package com.study.utils.functional.chapter6;

import org.junit.jupiter.api.Test;

import java.util.List;


public class BuggyReduceTest {

    @Test
    public void test() {
        List<Integer> integers = List.of(1, 2, 3, 4, 5);
        System.out.println(BuggyReduce.multiplyThroughBug(integers));
    }

}
