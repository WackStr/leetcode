package com.wackstr.leetcode.learn.linkedlist;

public class OddEvenList {

    /*
    Given the head of a singly linked list, group all the nodes with
    odd indices together followed by the nodes with even indices, and
    return the reordered list.
     */
    public ListNode oddEvenList(ListNode head){
        ListNode oddPtr = head;
        if(head != null) {


            ListNode evenPtr = head.next;
            ListNode rootEven = evenPtr;

            while (evenPtr != null && evenPtr.next != null) {
                oddPtr.next = evenPtr.next;
                oddPtr = oddPtr.next;
                evenPtr.next = oddPtr.next;
                evenPtr = evenPtr.next;
            }

            oddPtr.next = rootEven;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.fromArray(new int[]{1,2,3,4,5,6});
        OddEvenList sol = new OddEvenList();
        System.out.println(sol.oddEvenList(head));
    }
}
