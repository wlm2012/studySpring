package com.study.algorithms.leetcode._35;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void test() {
        Solution solution = new Solution();
        assertEquals(solution.searchInsert(new int[]{0, 9}, 4), 1);
        assertEquals(solution.searchInsert(new int[]{0, 4, 9}, 4), 1);

    }

}