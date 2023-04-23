package com.study.algorithms.leetcode._86;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void partitionTest() {
        ListNode node5 = new ListNode(2);
        ListNode node4 = new ListNode(5, node5);
        ListNode node3 = new ListNode(2, node4);
        ListNode node2 = new ListNode(3, node3);
        ListNode node1 = new ListNode(4, node2);
        ListNode node0 = new ListNode(1, node1);
        Solution solution = new Solution();
        solution.partition(node0, 3);
    }


}