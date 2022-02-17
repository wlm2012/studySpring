package com.study.algorithms.leetcode._15;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void test() {
        int[] ints = {1, -1, -1, 0};
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.threeSum(ints);
        System.out.println(lists);
    }


}