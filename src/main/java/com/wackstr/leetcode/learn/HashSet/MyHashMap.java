package com.wackstr.leetcode.learn.HashSet;

public class MyHashMap {
    private static final int CAPACITY = 10_000;
    private final Node[] arr = new Node[CAPACITY];

    private static class Node {
        int key;
        int val;
        Node left;
        Node right;

        public Node(int key, int val, Node left, Node right) {
            this.key = key;
            this.val = val;
            this.left = left;
            this.right = right;
        }

        private void add(int key, int val) {

            Node currNode = this;
            Node node = new Node(key, val, null, null);
            while (currNode != null) {
                if (currNode.key == key) {
                    currNode.val = val;
                    break;
                }
                else if (key < currNode.key) {
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

        public int get(int key) {
            Node curr = this;
            while (curr != null) {
                if (curr.key == key) return curr.val;
                else curr = key < curr.key ? curr.left : curr.right;
            }
            return -1;
        }

        private Node remove(int key) {
            if (this.key == key) return merge(left, right);
            else if (key < this.key && left != null) {
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
                temp.add(left.key, left.val);
            }else{
                temp = left;
            }
            return temp;
        }
    }

    public void put(int key, int val){
        int index = getIndex(key);
        if(arr[index] == null) arr[index] = new Node(key, val,null, null);
        else arr[index].add(key, val);
    }

    public int get(int key){
        int index = getIndex(key);
        if(arr[index] == null) return -1;
        else return arr[index].get(key);
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

    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put(1,1);
        map.put(2,2);
        System.out.println(map.get(1));
        System.out.println(map.get(3));
        map.put(2, 5);
        System.out.println(map.get(2));
        map.remove(2);
        System.out.println(map.get(2));
    }
}
