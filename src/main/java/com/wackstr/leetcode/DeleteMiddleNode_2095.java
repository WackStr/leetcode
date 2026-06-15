package com.wackstr.leetcode;

import com.wackstr.leetcode.learn.linkedlist.ListNode;

/*
2026-06-15 2095
 */
public class DeleteMiddleNode_2095 {
    public ListNode deleteMiddle(ListNode head) {
        ListNode mid = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast != null){
            fast = fast.next;
            if(fast == null)break;
            prev = mid;
            mid = mid.next;
            fast = fast.next;
        }
        if(prev == null) return null;
        prev.next = mid.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.fromArray(new int[]{1,2,3,4});
        DeleteMiddleNode_2095 sol = new DeleteMiddleNode_2095();
        System.out.println(sol.deleteMiddle(head));
    }
}
