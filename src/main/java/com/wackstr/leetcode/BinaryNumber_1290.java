package com.wackstr.leetcode;

import com.wackstr.leetcode.learn.linkedlist.ListNode;

/*
2025-07-14
 */
public class BinaryNumber_1290 {
    public int getDecimalValue(ListNode head) {
        int x = head.val;
        ListNode curr = head.next;
        while(curr != null){
            x <<= 1;
            x += curr.val;
            curr = curr.next;
        }
        return x;
    }

    public static void main(String[] args) {
        int[] arr = {1};
        ListNode head = ListNode.fromArray(arr);
        BinaryNumber_1290 sol = new BinaryNumber_1290();
        System.out.println(sol.getDecimalValue(head));
    }
}
