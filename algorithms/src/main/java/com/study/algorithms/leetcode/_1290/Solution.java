package com.study.algorithms.leetcode._1290;

class Solution {
    public int getDecimalValue(ListNode head) {
        int num = 0;
        while (head != null) {
            num <<= 1;
            num |= head.val;
            head = head.next;
        }
        return num;
    }
}
