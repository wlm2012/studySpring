package com.study.algorithms.leetcode._28;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void strStr() {
        Solution solution = new Solution();
        assertEquals(solution.strStr("hello", "ll"), 2);
        assertEquals(solution.strStr("", "ll"), 0);
        assertEquals(solution.strStr("hello", ""), 0);
        assertEquals(solution.strStr("hello", "al"), -1);
    }
}