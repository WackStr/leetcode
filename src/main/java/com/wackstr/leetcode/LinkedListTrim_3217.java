package com.wackstr.leetcode;

import com.wackstr.leetcode.learn.linkedlist.ListNode;

import java.util.HashSet;
import java.util.Set;

/*
2025-11-01
 */
public class LinkedListTrim_3217 {
    public ListNode modifiedList(int[] nums, ListNode head){
        Set<Integer> lookup = new HashSet<>();
        for(int num : nums) lookup.add(num);

        ListNode curr = head;
        while(curr != null && lookup.contains(curr.val)) curr = curr.next;
        ListNode newHead = curr;
        ListNode newCurr = newHead;
        if(curr != null) {
            curr = curr.next;
            while (curr != null) {
                if (!lookup.contains(curr.val)) {
                    newCurr.next = curr;
                    newCurr = curr;
                }
                curr = curr.next;
            }
        }
        newCurr.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        int[] nums = {9, 2, 5};
        ListNode head = ListNode.fromArray(new int[]{2, 10, 9});
        LinkedListTrim_3217 sol = new LinkedListTrim_3217();
        System.out.println(sol.modifiedList(nums, head));
    }
}
