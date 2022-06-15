package com.study.algorithms.leetcode._19;

import java.util.ArrayList;

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ArrayList<ListNode> listNodes = new ArrayList<>();
        ListNode listNode = new ListNode(0);
        listNode.next = head;
        listNodes.add(listNode);
        while (head != null) {
            listNodes.add(head);
            head = head.next;
        }
        ListNode node = listNodes.get(listNodes.size() - n - 1);
        node.next = node.next.next;
        return listNodes.get(0).next;
    }
}
