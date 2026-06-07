package com.wackstr.leetcode;

import com.sun.source.tree.Tree;
import com.wackstr.leetcode.structure.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
2026-06-07 2196
 */
public class BinaryTreeConstruction_2196 {
    public TreeNode createBinaryTree(int[][] descriptions) {
        // Maps values to TreeNode pointers
        Map<Integer, TreeNode> nodeMap = new HashMap<>();

        // Stores values which are children in the descriptions
        Set<Integer> children = new HashSet<>();

        // Iterate through descriptions to create nodes and set up tree structure
        for (int[] description : descriptions) {
            // Extract parent value, child value, and whether it is a
            // left child (1) or right child (0)
            int parentValue = description[0];
            int childValue = description[1];
            boolean isLeft = description[2] == 1;

            // Create parent and child nodes if not already created
            if (!nodeMap.containsKey(parentValue)) {
                nodeMap.put(parentValue, new TreeNode(parentValue));
            }
            if (!nodeMap.containsKey(childValue)) {
                nodeMap.put(childValue, new TreeNode(childValue));
            }

            // Attach child node to parent's left or right branch
            if (isLeft) {
                nodeMap.get(parentValue).left = nodeMap.get(childValue);
            } else {
                nodeMap.get(parentValue).right = nodeMap.get(childValue);
            }

            // Mark child as a child in the set
            children.add(childValue);
        }

        // Find and return the root node
        for (Integer parent : nodeMap.keySet()) {
            if (!children.contains(parent)) {
                return nodeMap.get(parent); // Root node found
            }
        }

        return null; // Should not occur according to problem statement
    }

    public static void main(String[] args) {
        int[][] descriptions = {{20,15,1},{20,17,0},{50,20,1},{50,80,0},{80,19,1}};
        BinaryTreeConstruction_2196 sol = new BinaryTreeConstruction_2196();
        System.out.println(sol.createBinaryTree(descriptions));
    }
}
