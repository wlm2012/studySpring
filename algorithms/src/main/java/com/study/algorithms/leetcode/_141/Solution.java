package com.study.algorithms.leetcode._141;

public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode first = head;
        ListNode next = head.next;
        while (first != next) {
            if (next.next == null || next.next.next == null) {
                return false;
            }
            first = first.next;
            next = next.next.next;
        }
        return true;
    }
}
