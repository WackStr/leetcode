package com.wackstr.leetcode.learn.HashSet;

public class MyHashSet {

    private static final int CAPACITY = 10_000;
    private final Node[] arr = new Node[CAPACITY];

    private static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        private void add(int val) {

            Node currNode = this;
            Node node = new Node(val, null, null);
            while (currNode != null) {
                if (currNode.val == val) break;
                else if (val < currNode.val) {
                    if (currNode.left == null) {
                        currNode.left = node;
                        currNode = null;
                    } else {
                        currNode = currNode.left;
                    }
                } else {
                    if (currNode.right == null) {
                        currNode.right = node;
                        currNode = null;
                    } else {
                        currNode = currNode.right;
                    }
                }
            }
        }

        public boolean contains(int key) {
            Node curr = this;
            while (curr != null) {
                if (curr.val == key) return true;
                else curr = key < curr.val ? curr.left : curr.right;
            }
            return false;
        }

        private Node remove(int key) {
            if (val == key) return merge(left, right);
            else if (key < val && left != null) {
                left = left.remove(key);
            } else if(right != null){
                right = right.remove(key);
            }
            return this;
        }

        public static Node merge(Node left, Node right) {
            if (left == null) return right;
            Node temp = merge(left.left, left.right);
            temp = merge(temp, right);
            if(temp != null) {
                temp.add(left.val);
            }else{
                temp = left;
            }
            return temp;
        }
    }

    public void add(int key){
        int index = getIndex(key);
        if(arr[index] == null) arr[index] = new Node(key, null, null);
        else arr[index].add(key);
    }

    public boolean contains(int key){
        int index = getIndex(key);
        if(arr[index] == null) return false;
        else return arr[index].contains(key);
    }

    public void remove(int key){
        int index = getIndex(key);
        if(arr[index] != null){
            arr[index] = arr[index].remove(key);
        }
    }

    private int getIndex(int key){
        return key % CAPACITY;
    }
}
