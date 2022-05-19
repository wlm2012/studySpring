package com.study.algorithms.leetcode.offer_06;

class Solution {
    public int[] reversePrint(ListNode head) {
        int num = 0;
        ListNode first = head;
        while (head != null) {
            num++;
            head = head.next;
        }
        int[] ints = new int[num];
        for (int i = ints.length - 1; i >= 0; i--) {
            ints[i] = first.val;
            first = first.next;
        }
        return ints;
    }
}
