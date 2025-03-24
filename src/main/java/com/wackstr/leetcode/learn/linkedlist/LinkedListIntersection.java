package com.wackstr.leetcode.learn.linkedlist;

public class LinkedListIntersection {

    private static class ListNode{
        int val;
        ListNode next;
        public ListNode(int x){
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        int lengthA = 1;
        int lengthB = 1;
        ListNode tailA = headA;
        ListNode tailB = headB;
        while(tailA.next != null){
            tailA = tailA.next;
            lengthA++;
        }
        while(tailB.next != null){
            tailB = tailB.next;
            lengthB++;
        }
        if(tailA == tailB){
            int skip = Math.abs(lengthA - lengthB);
            if(lengthA > lengthB){
                while(skip > 0){
                    headA = headA.next;
                    skip--;
                }
            }else{
                while(skip > 0){
                    headB = headB.next;
                    skip--;
                }
            }
            while(headA != headB){
                headA = headA.next;
                headB = headB.next;
            }
            return headA;
        }else{
            return null;
        }
    }

    public static void main(String[] args) {
        ListNode headA = new ListNode(1);
        ListNode headB = new ListNode(3);

        headA.next = new ListNode(9);
        headA.next.next = new ListNode(1);
        headB.next = new ListNode(2);
        headA.next.next.next = headB.next;
        headB.next.next = new ListNode(4);

        LinkedListIntersection sol = new LinkedListIntersection();
        System.out.println(sol.getIntersectionNode(headA, headB).val);
    }
}
