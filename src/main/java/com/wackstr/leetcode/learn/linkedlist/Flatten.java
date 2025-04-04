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
                // recursively flatten this child - this returns the child
                // and all nodes in a flat list
                Node child = flatten(curr.child);

                /*
                following pointer adjustments need to be made

                curr <-> child ... childEnd <-> curr.next

                the order needs to be carefully handled

                child.prev to curr
                childEnd.next to curr.next
                curr.next.prev to childEnd
                curr.next to child
                 */
                child.prev = curr;
                Node childEnd = child;
                while(childEnd.next != null){
                    childEnd = childEnd.next;
                }
                childEnd.next = curr.next;
                if(curr.next != null) curr.next.prev = childEnd;
                curr.next = child;
                curr.child = null;
                // jump to the end
                curr = childEnd.next;
            }
        }
        return head;
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
