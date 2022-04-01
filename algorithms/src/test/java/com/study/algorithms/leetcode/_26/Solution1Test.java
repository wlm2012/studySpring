package com.study.algorithms.leetcode._26;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution1Test {

    @Test
    public void test() {
        Solution1 solution1 = new Solution1();
        int i = solution1.removeDuplicates(new int[]{1, 1, 2});
        assertEquals(2, i);
    }

}