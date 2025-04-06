package com.wackstr.leetcode.learn.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class RandomPointers {
    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val){
            this.val = val;
            next = null;
            random = null;
        }
    }

    public Node copyRandomList(Node head){
        if(head == null) return null;
        Node newHead = new Node(head.val);
        Node newPtr = newHead;
        Node ptr = head;
        Map<Node, Node> nodeMap = new HashMap<>();
        while(ptr != null){
            nodeMap.put(ptr, newPtr);
            ptr = ptr.next;
            if(ptr != null) {
                Node newNode = new Node(ptr.val);
                newPtr.next = newNode;
                newPtr = newNode;
            }
        }
        ptr = head;
        while(ptr != null){
            if(ptr.random != null){
                nodeMap.get(ptr).random = nodeMap.get(ptr.random);
            }
            ptr = ptr.next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        Node head = null;
        RandomPointers sol = new RandomPointers();
        System.out.println(sol.copyRandomList(head));
    }
}
