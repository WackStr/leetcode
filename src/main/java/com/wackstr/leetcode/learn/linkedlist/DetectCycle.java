package com.wackstr.leetcode.learn.linkedlist;

public class DetectCycle {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
            if(fast != null){
                fast = fast.next;
                if (slow == fast){
                    ListNode ptr = head;
                    while(ptr != slow){
                        ptr = ptr.next;
                        slow = slow.next;
                    }
                    return ptr;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;

        DetectCycle sol = new DetectCycle();
        System.out.println(sol.detectCycle(head));
    }
}
