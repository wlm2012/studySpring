package com.study.algorithms.leetcode._21;

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode listNode = new ListNode(0);
        ListNode pre = listNode;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                listNode.next = list1;
                list1 = list1.next;
            } else {
                listNode.next = list2;
                list2 = list2.next;
            }
            listNode = listNode.next;
        }
        listNode.next = list2 == null ? list1 : list2;
        return pre.next;
    }
}