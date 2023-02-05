package com.study.algorithms.leetcode._86;

class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode headNode = new ListNode();
        ListNode pointNode = head;
        headNode.next = head;
        while (headNode.next != null) {
            if (headNode.next.val < x && pointNode != headNode.next) {
                ListNode next = pointNode.next;
                pointNode.next = headNode.next;
                pointNode.next.next = next;
                pointNode = pointNode.next;
                headNode.next = headNode.next.next;
            }
            headNode = headNode.next;
        }
        return head;
    }
}
