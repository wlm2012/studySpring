package com.study.algorithms.leetcode._234;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void test() {
        ListNode node4 = new ListNode(1);
        ListNode node3 = new ListNode(2, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode listNode = new ListNode(1, node2);
        Solution solution = new Solution();
        assertTrue(solution.isPalindrome(listNode));
    }
}