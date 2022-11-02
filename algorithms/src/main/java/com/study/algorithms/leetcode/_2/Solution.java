package com.study.algorithms.leetcode._2;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int i1 = l1.val;
        int i2 = l2.val;
        int carry = 0;
        ListNode listNode = null;
        if (i1 + i2 + carry > 9) {
            listNode = new ListNode(i1 + i2 + carry - 10);
            carry = 1;
        } else {
            listNode = new ListNode(i1 + i2 + carry);
        }
        ListNode result = listNode;
        while (l1.next != null || l2.next != null || carry > 0) {

            if (l1.next != null) {
                l1 = l1.next;
                i1 = l1.val;
            } else {
                i1 = 0;
            }

            if (l2.next != null) {
                l2 = l2.next;
                i2 = l2.val;
            } else {
                i2 = 0;
            }
            if (i1 + i2 + carry > 9) {
                listNode.next = new ListNode(i1 + i2 + carry - 10);
                carry = 1;
            } else {
                listNode.next = new ListNode(i1 + i2 + carry);
                carry = 0;
            }

            listNode = listNode.next;
        }
        return result;
    }
}
