package com.wackstr.leetcode.learn.stack;

import java.util.*;

public class DeepClone {
    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Node newNode = new Node(node.val);
        Map<Integer, Node> newNodes = new HashMap<>();
        Set<Integer> seen = new HashSet<>();

        newNodes.put(node.val, newNode);
        seen.add(node.val);
        dfs(node, newNodes, seen);

        return newNode;
    }

    public void dfs(
            Node currNode,
            Map<Integer,Node> newNodes,
            Set<Integer> seen){
        if(currNode == null) return;

        Node cloneNode =
                newNodes.computeIfAbsent(currNode.val,
                        k -> new Node(currNode.val));


        for(Node neighbor : currNode.neighbors){
            Node cloneNeighbor =
                    newNodes.computeIfAbsent(neighbor.val,
                            k -> new Node(neighbor.val));
            cloneNode.neighbors.add(cloneNeighbor);
            if(!seen.contains(neighbor.val)){
                seen.add(neighbor.val);
                dfs(neighbor, newNodes, seen);
            }
        }
    }
}
