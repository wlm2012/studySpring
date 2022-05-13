package com.study.algorithms.leetcode._01_05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void test() {
        Solution solution = new Solution();
        assertTrue(solution.oneEditAway("islander", "slander"));
        assertTrue(solution.oneEditAway("a", ""));
        assertTrue(solution.oneEditAway("ab", "b"));
        assertTrue(solution.oneEditAway("ab", "a"));
    }

}