package com.study.algorithms.leetcode.offer_25;

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode first = listNode;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                listNode.next = l2;
                l2 = l2.next;
            } else {
                listNode.next = l1;
                l1 = l1.next;
            }
            listNode = listNode.next;
        }
        listNode.next = l2 == null ? l1 : l2;
        return first.next;
    }
}
