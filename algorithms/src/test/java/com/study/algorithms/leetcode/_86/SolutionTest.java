package com.study.algorithms.leetcode._86;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void partitionTest() {
        ListNode node3 = new ListNode(4);
        ListNode node2 = new ListNode(5, node3);
        ListNode node1 = new ListNode(2, node2);
        ListNode node0 = new ListNode(9, node1);
        Solution solution = new Solution();
        solution.partition(node0, 6);
    }


}