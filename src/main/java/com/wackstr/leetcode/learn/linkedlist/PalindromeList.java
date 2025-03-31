package com.wackstr.leetcode.learn.linkedlist;

public class PalindromeList {
    /*
    Given the head of a singly linked list, return true if it is a
    palindrome or false otherwise.

    This approach moves a fast pointer and slow pointer. it reverses the list
    based on the slow pointer

    Once fast pointer reaches end

    start at new head and compare values with the slow pointer
     */

    public boolean isPalindrome(ListNode head){
        if(head == null) return true;
        ListNode nextNode = head.next;
        ListNode newHead = head;
        ListNode fastNode = head;
        while(nextNode != null){
            fastNode = fastNode.next;
            // list is odd length, move new head forward from the pivot
            if(fastNode == null) {
                newHead = newHead.next;
                break;
            }
            fastNode = fastNode.next;

            // don't reverse if fastNode has reached end
            if(fastNode == null) break;

            head.next = nextNode.next;
            nextNode.next = newHead;
            newHead = nextNode;
            nextNode = head.next;
        }
        while(nextNode != null){
            if(nextNode.val != newHead.val) return false;
            nextNode = nextNode.next;
            newHead = newHead.next;
        }
        return true;
    }

    /*
    This moves fast pointer to end

    uses method to reverse second half of list and compare with the current head
     */
    private boolean reverseListPalindrome(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        int n = 0;
        while(fastPointer != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
            if(fastPointer != null) fastPointer = fastPointer.next;
            n++;
        }
        // reverse the list at slow pointer
        slowPointer = reverseList(slowPointer);
        while (n > 0 && head != null && slowPointer != null) {
            if(head.val != slowPointer.val)
                return false;
            head = head.next;
            slowPointer = slowPointer.next;
            n--;
        }
        return true;
    }

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

    public static void main(String[] args) {
        ListNode head = ListNode.fromArray(new int[]{1, 2, 3,1});
        PalindromeList sol = new PalindromeList();
        System.out.println(sol.isPalindrome(head));
    }
}
