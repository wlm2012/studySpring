package com.study.algorithms.leetcode.m_02_02;


import java.util.ArrayList;

class Solution {
    public int kthToLast(ListNode head, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return list.get(list.size() - k);
    }
}
