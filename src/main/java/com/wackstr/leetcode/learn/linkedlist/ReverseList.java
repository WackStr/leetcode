package com.wackstr.leetcode.learn.linkedlist;

public class ReverseList {
    /*
    iterate the nodes in original order and move them to the head of the
    list one by one
     */
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
