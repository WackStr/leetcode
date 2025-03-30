package com.wackstr.leetcode.learn.linkedlist;

public class RemoveElement {
    /*
    Given the head of a linked list and an integer val, remove all the
    nodes of the linked list that has Node.val == val, and return the new head.
     */
    public ListNode removeElements(ListNode head, int val){
        ListNode curr = head;
        while(curr != null && curr.val == val){
            curr = curr.next;
        }
        ListNode newHead = curr;
        while(curr != null){
            ListNode nextPtr = curr.next;
            while(nextPtr != null && nextPtr.val == val){
                nextPtr = nextPtr.next;
            }
            curr.next = nextPtr;
            curr = nextPtr;
        }
        return newHead;
    }

    public static void main(String[] args) {
        int[] listArray = {1,2,6,3,4,5,6};
        int val = 6;
        ListNode head = ListNode.fromArray(listArray);
        RemoveElement sol = new RemoveElement();
        System.out.println(head);
        System.out.println(sol.removeElements(head, val));
    }
}
