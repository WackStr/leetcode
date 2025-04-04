package com.wackstr.leetcode.structure;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode fromArray(Integer[] points) {
        if (points.length > 0 && points[0] != null) {
            TreeNode root = new TreeNode(points[0]);
            Deque<TreeNode> stack = new LinkedList<>();
            stack.add(root);
            for(int i = 1; i < points.length; i += 2){
                TreeNode parent = stack.remove();
                if(points[i] != null){
                    TreeNode leftNode = new TreeNode(points[i]);
                    parent.left = leftNode;
                    stack.add(leftNode);
                }
                if(i + 1 < points.length && points[i+1] != null){
                    TreeNode rightNode = new TreeNode(points[i+1]);
                    parent.right = rightNode;
                    stack.add(rightNode);
                }
            }
            return root;
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        Deque<TreeNode> nodes = new LinkedList<>();
        Deque<Integer> nodesCollected = new LinkedList<>();
        nodes.add(this);
        nodesCollected.add(this.val);
        while (!nodes.isEmpty()) {
            TreeNode curr = nodes.remove();
            if (curr != null && (curr.left != null || curr.right != null)) {
                if (curr.left != null) {
                    nodesCollected.add(curr.left.val);
                    nodes.add(curr.left);
                }else{
                    nodesCollected.add(null);
                }
                if (curr.right != null) {
                    nodesCollected.add(curr.right.val);
                    nodes.add(curr.right);
                }else{
                    nodesCollected.add(null);
                }
            }
        }
        return Arrays.toString(nodesCollected.toArray());
    }
}