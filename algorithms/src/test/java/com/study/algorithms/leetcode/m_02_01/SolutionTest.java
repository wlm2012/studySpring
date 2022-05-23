package com.study.algorithms.leetcode.m_02_01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void test() {
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(1);
        Solution solution = new Solution();
        solution.removeDuplicateNodes(listNode1);
    }

}