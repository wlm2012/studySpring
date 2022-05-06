package com.study.algorithms.leetcode._27;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void test() {
        int[] temp = {0, 1, 2, 2, 3, 0, 4, 2};
        Solution solution = new Solution();
        assertEquals(solution.removeElement(temp, 2), 5);
    }

}