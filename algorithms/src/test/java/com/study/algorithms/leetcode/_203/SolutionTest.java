package com.study.algorithms.leetcode._203;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void test() {
        Solution solution = new Solution();
        ListNode node3 = new ListNode(6);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        solution.removeElements(node1,6);
    }

}