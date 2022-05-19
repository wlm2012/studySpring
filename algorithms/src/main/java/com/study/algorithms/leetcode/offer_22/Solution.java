package com.study.algorithms.leetcode.offer_22;


class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        int num = 0;
        ListNode first = head;
        while (head != null) {
            num++;
            head = head.next;
        }
        num = num - k;
        for (int i = 0; i < num; i++) {
            first = first.next;
        }
        return first;
    }
}