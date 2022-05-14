package com.study.algorithms.leetcode._160;

import java.util.HashSet;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> listNodes = new HashSet<>();
        listNodes.add(headA);
        while (headA.next != null) {
            listNodes.add(headA.next);
            headA = headA.next;
        }

        if (listNodes.contains(headB)) {
            return headB;
        }
        while (headB.next != null) {
            if (listNodes.contains(headB.next)) {
                return headB.next;
            }
            headB = headB.next;
        }
        return null;
    }
}
