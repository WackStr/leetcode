package com.wackstr.leetcode.learn.linkedlist;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x){
        val = x;
        next = null;
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        ListNode curr = this;
        while(curr != null){
            s.append(String.format("%s -> ", curr.val));
            curr = curr.next;
        }
        return s.toString();
    }

    public static ListNode fromArray(int[] nums){
        ListNode head = new ListNode(nums[0]);
        ListNode curr = head;
        for(int i = 1; i < nums.length; i++){
            curr.next = new ListNode(nums[i]);
            curr = curr.next;
        }
        return head;
    }

}
