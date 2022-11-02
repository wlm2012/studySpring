package com.study.algorithms.leetcode._61;

import java.util.ArrayList;

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        ArrayList<Integer> list = new ArrayList<>();
        ListNode pre = head;
        ListNode listNode = head;
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        k %= list.size();
        int j = list.size() - k - 1;
        for (int i = 0; i < j; i++) {
            listNode = listNode.next;
        }
        listNode.next = null;

        for (int i = 0; i < k; i++) {
            ListNode node = new ListNode(list.get(list.size() - i - 1));
            node.next = pre;
            pre = node;
        }
        return pre;
    }
}
