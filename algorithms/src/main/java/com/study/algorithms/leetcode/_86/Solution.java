package com.study.algorithms.leetcode._86;

/**
 * 修改原链表，较为复杂
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head==null){
            return null;
        }
        ListNode headNode = new ListNode();
        ListNode pointNode = new ListNode(-300);
        pointNode.next = head;
        headNode.next = head;
        ListNode node = pointNode;
        while (headNode.next != null) {
            if (headNode.next.val < x) {
                if (pointNode.next != headNode.next) {
                    ListNode headNext = headNode.next;
                    headNode.next = headNode.next.next;
                    ListNode pointNext = pointNode.next;
                    pointNode.next = headNext;
                    headNext.next = pointNext;
                }else {
                    headNode = headNode.next;
                }
                pointNode = pointNode.next;
            }else {
                headNode = headNode.next;
            }
        }
        return node.next;
    }
}
