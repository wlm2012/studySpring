package com.study.algorithms.leetcode._206;

import java.util.ArrayList;

class Solution {
    public ListNode reverseList(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        ListNode node = new ListNode(0);
        ListNode first = node;
        for (int i = list.size() - 1; i >= 0; i--) {
            node.next = new ListNode(list.get(i));
            node = node.next;
        }
        return first.next;
    }
}