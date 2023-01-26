package com.study.algorithms.leetcode._86;

class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode headNode = new ListNode();
        ListNode pointNode = new ListNode();
        headNode.next = head;
        pointNode.next = head;
        if (head.val < x) {

        }
        while (head.next != null) {
            if (head.next.val < x) {

                head.next = head.next.next;
            }
        }

    }
}
