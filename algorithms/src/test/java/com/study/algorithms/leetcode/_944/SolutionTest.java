package com.study.algorithms.leetcode._944;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void test() {
        Solution solution = new Solution();
        assertEquals(solution.minDeletionSize(new String[]{"cba", "daf", "ghi"}), 1);
        assertEquals(solution.minDeletionSize(new String[]{"a", "b"}), 0);
    }

    @Test
    void test1() {
        Solution solution = new Solution();
        assertEquals(solution.minDeletionSize(new String[]{"rrjk","furt","guzm"}), 2);
    }
}