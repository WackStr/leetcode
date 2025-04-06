package com.wackstr.leetcode.learn.linkedlist;

public class Flatten {

    public static class Node{
        int val;
        Node prev;
        Node next;
        Node child;
    }

    /*
    You are given a doubly linked list, which contains nodes that have a
    next pointer, a previous pointer, and an additional child pointer.
    This child pointer may or may not point to a separate doubly linked list,
    also containing these special nodes. These child lists may have one or
    more children of their own, and so on, to produce a multilevel data
    structure.

    Given the head of the first level of the list, flatten the list so that
    all the nodes appear in a single-level, doubly linked list. Let curr be
    a node with a child list. The nodes in the child list should appear after
    curr and before curr.next in the flattened list.

    Return the head of the flattened list. The nodes in the list must have all
    of their child pointers set to null.
     */
    public Node flatten(Node head){
        Node curr = head;
        // iterate to the end of the list
        while(curr != null) {
            // keep moving forward till you find a node with a child
            while (curr != null && curr.child == null) {
                curr = curr.next;
            }
            if (curr != null) {
                // recursively flatten this child - this returns the tail
                // of the flattened list
                Node tail = flattenToTail(curr.child);

                /*
                following pointer adjustments need to be made

                curr <-> child ... tail <-> curr.next

                the order needs to be carefully handled

                curr.child.prev to curr
                tail.next to curr.next
                curr.next.prev to tail
                curr.next to child
                 */
                curr.child.prev = curr;
                tail.next = curr.next;
                if(curr.next != null) curr.next.prev = tail;
                curr.next = curr.child;
                curr.child = null;
                // jump to the end
                curr = tail.next;
            }
        }
        return head;
    }

    /*
    When flattening, getting the tail is helpful so that we don't
    have to do an extra iteration towards the end of the flattened
    list to adjust our pointers in the main flatten function
     */
    public Node flattenToTail(Node head){
        Node curr = head;
        Node prev = null;
        while(curr != null) {
            while (curr != null && curr.child == null) {
                prev = curr;
                curr = curr.next;
            }
            if (curr != null) {
                Node tail = flattenToTail(curr.child);
                curr.child.prev = curr;
                tail.next = curr.next;
                if (curr.next != null) curr.next.prev = tail;
                curr.next = curr.child;
                curr.child = null;
                // jump to the end
                curr = tail.next;
                prev = tail;
            }
        }
        return prev;
    }

    public static void main(String[] args) {
        Node head = new Node();
        head.val = 1;
        head.child = new Node();
        head.child.val = 3;
        head.next = new Node();
        head.next.val = 2;
        Flatten sol = new Flatten();
        sol.flatten(head);
    }
}
