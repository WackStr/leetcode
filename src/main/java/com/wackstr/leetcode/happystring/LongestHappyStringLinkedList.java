package com.wackstr.leetcode.happystring;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class LongestHappyStringLinkedList extends LongestHappyString{

    private static class Node {
        private Node prev;
        private Node next;
        private final String val;

        public Node(Node prev, Node next, String val) {
            this.prev = prev;
            this.next = next;
            this.val = val;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public String getVal() {
            return val;
        }

        @Override
        public String toString(){
            StringBuilder ans = new StringBuilder();
            Node currNode = this;
            while(currNode != null){
                ans.append(currNode.getVal());
                currNode = currNode.getNext();
            }
            return ans.toString();
        }
    }

    @Override
    public String longestDiverseString(int a, int b, int c) {

        Node first = null;
        PriorityQueue<StringRepresentation> queue =
                initializePriorityQueue(a, b, c);
        Deque<StringRepresentation> runningSet = new ArrayDeque<>();

        while(!queue.isEmpty()){
            StringRepresentation curr = queue.poll();
            if(curr.cnt() > 0){
                if(first == null){
                    first = addFirstNode(curr, queue);
                }else{
                    boolean added = tryAddNode(first, curr, queue, runningSet);
                    if(!added){
                        runningSet.add(curr);
                    }
                }
            }else{
                break;
            }
        }
        return first != null ? first.toString() : "";
    }

    private static boolean tryAddNode(
            Node first,
            StringRepresentation curr,
            PriorityQueue<StringRepresentation> queue,
            Deque<StringRepresentation> runningSet) {
        Node currNode = first;
        boolean added = false;
        while(currNode != null){
            boolean additionIsValid = isAdditionValid(currNode, curr);
            if(additionIsValid){
                processAddition(currNode, curr, queue, runningSet);
                added = true;
                break;
            }
            currNode = currNode.next;
        }
        return added;
    }

    private static boolean isAdditionValid(
            Node first, StringRepresentation curr) {
        // is not first char
        boolean isStartValid =
                (first.getNext() == null || first.getNext().getNext() == null)
                ||
                (!first.getNext().getVal().equals(curr.str()) || !first.getNext().getNext().getVal().equals(curr.str()));
        // is not last char
        boolean lastCase =
                first.getPrev() == null
                || (!first.getVal().equals(curr.str()) || !first.getPrev().getVal().equals(curr.str()));
        // is not middle char
        boolean midCase =
                first.getNext() == null ||
                !first.getVal().equals(curr.str()) || !first.getNext().getVal().equals(curr.str());

        return isStartValid && lastCase && midCase;
    }

    private static Node addFirstNode(
            StringRepresentation curr,
            PriorityQueue<StringRepresentation> queue) {
        Node first = new Node(null, null, curr.str());
        queue.add(new StringRepresentation(curr.str(), curr.cnt() - 1));
        return first;
    }

    private static void processAddition(
            Node currNode,
            StringRepresentation curr,
            PriorityQueue<StringRepresentation> queue,
            Deque<StringRepresentation> runningSet) {
        insertNode(currNode, curr);
        queue.add(new StringRepresentation(curr.str(), curr.cnt() - 1));
        insertRunningSet(runningSet, queue);
    }

    private static void insertRunningSet(
            Deque<StringRepresentation> runningSet,
            PriorityQueue<StringRepresentation> queue) {
        while(!runningSet.isEmpty()){
            queue.add(runningSet.pop());
        }
    }

    private static void insertNode(Node currNode, StringRepresentation curr) {
        Node additionNode =
                new Node(currNode, currNode.getNext(), curr.str());
        if(currNode.getNext() != null){
            currNode.getNext().setPrev(additionNode);
        }
        currNode.setNext(additionNode);
    }
}
