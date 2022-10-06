package com.study.algorithms.leetcode._24;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode listNode = new ListNode();
        listNode.next = head;
        ListNode result = listNode;
        while (listNode.next != null && listNode.next.next != null) {
            ListNode first = listNode.next;
            ListNode second = listNode.next.next;
            listNode.next = second;
            first.next = second.next;
            second.next = first;
            listNode = listNode.next.next;
        }
        return result.next;
    }
}
