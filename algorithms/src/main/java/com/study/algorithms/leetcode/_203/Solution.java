package com.study.algorithms.leetcode._203;

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode listNode = new ListNode(0, head);
        ListNode first = listNode;
        while (listNode.next != null) {
            if (listNode.next.val == val) {
                listNode.next = listNode.next.next;
                continue;
            }
            listNode = listNode.next;

        }
        return first.next;
    }
}
