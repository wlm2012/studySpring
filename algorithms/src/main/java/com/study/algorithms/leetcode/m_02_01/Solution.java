package com.study.algorithms.leetcode.m_02_01;

import java.util.HashSet;

class Solution {
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return null;
        }

        HashSet<Integer> set = new HashSet<>();
        ListNode first = head;
        set.add(head.val);
        while (head.next != null) {
            if (set.add(head.next.val)) {
                head = head.next;
            } else {
                head.next = head.next.next;
            }
        }
        return first;
    }
}
