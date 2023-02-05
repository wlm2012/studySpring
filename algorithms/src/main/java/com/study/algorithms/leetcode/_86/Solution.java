package com.study.algorithms.leetcode._86;

class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode headNode = new ListNode();
        ListNode pointNode = new ListNode(-300);
        pointNode.next = head;
        headNode.next = head;
        ListNode node = pointNode;
        while (headNode.next != null) {
            if (headNode.next.val < x && pointNode != headNode.next) {
                if (pointNode.next != headNode.next) {
                    ListNode next = pointNode.next;
                    headNode.next = headNode.next.next;
                    pointNode.next = headNode.next;
                    pointNode.next.next = next;
                }
                pointNode = pointNode.next;
            }
            headNode = headNode.next;
        }
        return node.next;
    }
}
