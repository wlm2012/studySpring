package com.study.algorithms.leetcode._6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void test() {
        Solution solution = new Solution();
        String convert = solution.convert("PAYPALISHIRING", 3);
        assertEquals("PAHNAPLSIIGYIR",convert);
    }

}