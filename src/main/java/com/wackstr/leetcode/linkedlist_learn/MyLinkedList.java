package com.wackstr.leetcode.linkedlist_learn;

class MyLinkedList {

    private static class Node {
        int val;
        Node next;

        public Node(int val){
            this.val = val;
        }
    }

    private Node head;
    private int length;

    public MyLinkedList() {
    }

    public int get(int index) {
        if(index < length) {
            Node curr = head;
            for(int i = 0; i < index; i++){
                curr = curr.next;
            }
            return curr.val;
        }else{
            return -1;
        }
    }

    public void addAtHead(int val) {
        Node curr = new Node(val);
        curr.next = head;
        head = curr;
        length++;
    }

    public void addAtTail(int val) {
        if(length == 0) addAtHead(val);
        else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = new Node(val);
            length++;
        }
    }

    public void addAtIndex(int index, int val) {
        if(index == 0) addAtHead(val);
        else if(index == length) addAtTail(val);
        else if(index < length) {
            Node curr = head;
            for (int i = 0; i < index - 1; i++) {
                curr = curr.next;
            }
            Node newNode = new Node(val);
            newNode.next = curr.next;
            curr.next = newNode;
            length++;
        }
    }

    public void deleteAtIndex(int index) {
        if(index < length) {
            if (index == 0) head = head.next;
            else {
                Node curr = head;
                for (int i = 0; i < index - 1; i++) {
                    curr = curr.next;
                }
                curr.next = curr.next.next;
            }
            length--;
        }
    }

    public static void main(String[] args) {
        MyLinkedList ls = new MyLinkedList();
        ls.addAtHead(7);
        ls.addAtHead(2);
        ls.addAtHead(1);
        ls.addAtIndex(3, 0);
        ls.deleteAtIndex(2);
        ls.addAtHead(6);
        ls.addAtTail(4);
        System.out.println(ls.get(4));
        ls.addAtHead(4);
        ls.addAtIndex(5, 0);
        ls.addAtHead(6);
    }
}
