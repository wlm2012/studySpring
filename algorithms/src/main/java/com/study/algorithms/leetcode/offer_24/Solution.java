package com.study.algorithms.leetcode.offer_24;

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode zero = head;
        if (head.next == null) {
            return head;
        }
        ListNode first = head.next;
        ListNode next = null;
        if (head.next != null) {
            next = head.next.next;
        }
        zero.next = null;
        while (first != null) {
            first.next = zero;
            if (next == null) {
                break;
            }
            zero = first;
            first = next;
            next = next.next;
        }
        return first;
    }
}
