package com.study.algorithms.leetcode._2;

class Solution1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode();
        ListNode pre = listNode;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int i1 = l1 != null ? l1.val : 0;
            int i2 = l2 != null ? l2.val : 0;
            int sum = i1 + i2 + carry;
            carry = sum / 10;
            listNode.next = new ListNode(sum % 10);
            listNode = listNode.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            listNode.next = new ListNode(carry);
        }
        return pre.next;
    }
}