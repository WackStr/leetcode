package com.wackstr.leetcode.learn.linkedlist;

public class RotateList {
    /*
    Given the head of a linked list, rotate the list to the right by k places.
     */
    public ListNode rotateRight(ListNode head, int k) {
        // handle base case
        if (head == null || k == 0) return head;

        // move forward till k steps or end of list
        int stepsLeft = k;
        ListNode curr = head;
        while (curr != null && stepsLeft > 0) {
            curr = curr.next;
            stepsLeft--;
        }

        if (stepsLeft != 0) {
            // if k > length of list mod by length of list (k - steps left)
            // rotate with this modded list to get the head after net rotation
            return rotateRight(head, k % (k - stepsLeft));
        }
        return rotate(head, curr);
    }

    private ListNode rotate(ListNode head, ListNode curr) {
        // if reached end no net rotation as k == length of list
        if (curr == null) return head;
        ListNode newHead = head;
        ListNode prev = head;
        ListNode tail = curr;
        while (curr != null) {
            prev = newHead;
            newHead = newHead.next;
            tail = curr;
            curr = curr.next;
        }
        prev.next = null;
        tail.next = head;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.fromArray(new int[]{1, 2, 3, 4, 5, 6});
        int k = 4;
        System.out.println(head);
        RotateList sol = new RotateList();
        System.out.println("after " + k + " rotations:");
        System.out.println(sol.rotateRight(head, k));
    }
}
