package com.wackstr.leetcode;

import com.wackstr.leetcode.learn.linkedlist.ListNode;

/*
2026-06-14 2130
 */
public class MaximumTwinSum_2130 {
    public int pairSum(ListNode head) {

        // use slow/fast pointer to find mid-point
        int n = 0;
        ListNode midPointer = head;
        ListNode fastPointer = head;
        while(fastPointer != null){
            n++;
            midPointer = midPointer.next;
            fastPointer = fastPointer.next;
            if(fastPointer != null) fastPointer = fastPointer.next;
        }

        // reverse the list after mid
        ListNode curr = midPointer;
        ListNode prev = null;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // prev now points to the end

        // iterate through the two lists and track running max
        int res = Integer.MIN_VALUE;
        curr = head;
        while(n > 0){
            res = Math.max(res, curr.val + prev.val);
            curr = curr.next;
            prev = prev.next;
            n--;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.fromArray(new int[]{5,4,2,1});
        MaximumTwinSum_2130 sol = new MaximumTwinSum_2130();
        System.out.println(sol.pairSum(head));
    }
}
