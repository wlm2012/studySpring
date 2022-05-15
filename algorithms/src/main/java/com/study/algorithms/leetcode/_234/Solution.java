package com.study.algorithms.leetcode._234;

class Solution {
    public boolean isPalindrome(ListNode head) {
        int length = 0;
        ListNode first = head;
        while (head != null) {
            length++;
            head = head.next;
        }
        int half = length / 2;
        int odd = length % 2;
        int[] ints = new int[half];
        head = first;
        for (int i = 0; i < half; i++) {
            ints[i] = head.val;
            head = head.next;
        }
        if (odd == 1) {
            head = head.next;
        }
        for (int i = half - 1; i >= 0; i--) {
            if (head.val != ints[i]) {
                return false;
            }
            head=head.next;
        }
        return true;
    }
}
