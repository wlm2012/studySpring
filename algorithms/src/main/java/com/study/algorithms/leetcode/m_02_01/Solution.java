package com.study.algorithms.leetcode.m_02_01;

import java.util.HashSet;

class Solution {
    public ListNode removeDuplicateNodes(ListNode head) {
        HashSet<Integer> set = new HashSet<>();
        ListNode first = head;
        while (head != null) {
            if (set.add(head.val)) {
                head = head.next;
            } else {
                head.next = (head.next == null ? null : head.next.next);
            }
        }
        return first;
    }
}
