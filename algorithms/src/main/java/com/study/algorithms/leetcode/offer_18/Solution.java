package com.study.algorithms.leetcode.offer_18;

class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode listNode = new ListNode(0);
        ListNode first = listNode;
        listNode.next = head;
        while (listNode.next != null) {
            if (listNode.next.val == val) {
                listNode.next = listNode.next.next;
                break;
            }
            listNode = listNode.next;
        }
        return first.next;
    }
}