package com.study.algorithms.leetcode.offer_52;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        while (headA != headB) {
            headA = headA != null ? headA.next : b;
            headB = headB != null ? headB.next : a;
        }
        return headA;
    }
}