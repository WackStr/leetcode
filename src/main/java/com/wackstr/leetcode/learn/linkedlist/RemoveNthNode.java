package com.wackstr.leetcode.learn.linkedlist;

public class RemoveNthNode {
    public static class ListNode {
        int val;
        ListNode next;
        public ListNode(int x){
            val = x;
            next = null;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n){
        ListNode leadPointer = head;
        ListNode lagPointer = head;
        while(leadPointer != null && n > 0){
            leadPointer = leadPointer.next;
            n--;
        }
        if(leadPointer != null){
            leadPointer = leadPointer.next;
        }else{
            return lagPointer.next;
        }
        while(leadPointer != null){
            leadPointer = leadPointer.next;
            lagPointer = lagPointer.next;
        }

        if(lagPointer.next != null){
            lagPointer.next = lagPointer.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int n = 2;
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        RemoveNthNode sol = new RemoveNthNode();
        System.out.println(sol.removeNthFromEnd(head, n));
    }
}
