package com.study.algorithms.leetcode.offer_24;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void test() {
        ListNode listNode3 = new ListNode(3);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode1 = new ListNode(1);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        Solution solution = new Solution();
        solution.reverseList(listNode1);
    }

}