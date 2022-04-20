package com.study.algorithms.leetcode._821;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    //[3,2,1,0,1,0,0,1,2,2,1,0]
    @Test
    void test() {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.shortestToChar("loveleetcode", 'e')));
    }

    //[2, 1, 0, 1]
    @Test
    void test2() {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.shortestToChar("aaba", 'b')));
    }

    @Test
    void test1(){
        System.out.println(Math.abs(-1));
    }

}