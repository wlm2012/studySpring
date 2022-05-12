package com.study.algorithms.leetcode._83;

class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        int before = head.val;
        ListNode old = head;
        while (head.next != null) {
            if (before == head.next.val) {
                if (head.next.next == null) {
                    head.next = null;
                } else {
                    head.next = head.next.next;
                }
            } else {
                head = head.next;
                before = head.val;
            }
        }
        return old;
    }
}