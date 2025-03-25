package com.wackstr.leetcode.learn.linkedlist;

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode nextNode = head.next;
        ListNode newHead = head;
        while(nextNode != null){
            head.next = nextNode.next;
            nextNode.next = newHead;
            newHead = nextNode;
            nextNode = head.next;
        }
        return newHead;
    }
}
