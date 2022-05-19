package com.study.algorithms.leetcode._876;

class Solution {
    public ListNode middleNode(ListNode head) {
        int num = 1;
        ListNode first = head;
        while (head.next != null) {
            num++;
            head = head.next;
        }
        int half = num / 2;
        for (int i = 0; i < half; i++) {
            first = first.next;
        }
        return first;
    }
}
