package com.study.algorithms.leetcode._61;

public class Solution1 {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode pre = head;
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        int size = 1;
        while (head.next != null) {
            size++;
            head = head.next;
        }
        int add = size - k % size;
        if (add == size) {
            return pre;
        }
        head.next = pre;
        while (add-- > 0) {
            head = head.next;
        }
        ListNode node = head.next;
        head.next = null;
        return node;
    }
}
