package com.wackstr.leetcode;

public class AddTwoNumbers {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString(){
            StringBuilder str = new StringBuilder();
            str.append(String.format("%d -> ", val));
            ListNode nextNode = next;
            while(nextNode != null){
                str.append(String.format("%d -> ", nextNode.val));
                nextNode = nextNode.next;
            }
            str.append("[]");
            return str.toString();
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode acc = new ListNode();
        ListNode currAcc = acc;
        ListNode currL1 = l1;
        ListNode currL2 = l2;
        boolean firstIter = true;
        int carry = 0;
        while(currL1 != null || currL2 != null){
            int v1 = getNodeValue(currL1);
            int v2 = getNodeValue(currL2);
            int sum = v1 + v2 + carry;
            int modulus = sum % 10;

            ListNode node = new ListNode(modulus);
            if(firstIter){
                acc = node;
                currAcc = node;
                firstIter = false;
            }else{
                currAcc.next = node;
                currAcc = node;
            }
            carry = sum / 10;
            currL1 = getNextNode(currL1);
            currL2 = getNextNode(currL2);
        }
        if(carry > 0){
            currAcc.next = new ListNode(1);
        }
        return acc;
    }

    private int getNodeValue(ListNode n){
        return n == null ? 0 : n.val;
    }

    private ListNode getNextNode(ListNode n){
        return n != null ? n.next : null;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        AddTwoNumbers adder = new AddTwoNumbers();
        ListNode l3 = adder.addTwoNumbers(l1, l2);
        System.out.println(l3);
    }
}
