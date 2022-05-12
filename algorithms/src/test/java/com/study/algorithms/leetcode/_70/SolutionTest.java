package com.study.algorithms.leetcode._70;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void test() {
        Solution solution = new Solution();
        assertEquals(solution.climbStairs(3), 3);
        assertEquals(solution.climbStairs(2), 2);
        assertEquals(solution.climbStairs(38), 63245986);
    }

}