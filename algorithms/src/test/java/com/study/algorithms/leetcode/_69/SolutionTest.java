package com.study.algorithms.leetcode._69;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void test() {
        Solution solution = new Solution();
        assertEquals(solution.mySqrt(2147395599), (int) Math.sqrt(2147395599));
        assertEquals(solution.mySqrt(1), (int) Math.sqrt(1));
    }

}