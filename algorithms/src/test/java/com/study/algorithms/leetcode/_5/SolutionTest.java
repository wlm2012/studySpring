package com.study.algorithms.leetcode._5;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private static Solution solution;

    @BeforeAll
    static void init() {
        solution = new Solution();
    }

    @Test
    void test() {
        System.out.println(solution.longestPalindrome("babad"));
        assertEquals("bab", solution.longestPalindrome("babad"));
    }

    @Test
    void test1() {
        assertEquals("bb", solution.longestPalindrome("cbbd"));

    }

    @Test
    void test2() {
        assertEquals("bb", solution.longestPalindrome("bb"));
    }

}