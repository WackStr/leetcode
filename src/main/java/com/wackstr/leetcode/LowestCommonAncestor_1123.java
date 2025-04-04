package com.wackstr.leetcode;

import com.wackstr.leetcode.structure.Pair;
import com.wackstr.leetcode.structure.TreeNode;/*
2025-04-04
 */

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;


public class LowestCommonAncestor_1123 {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return dfs(root).getKey();
    }

    private Pair<TreeNode, Integer> dfs(TreeNode root) {
        if (root == null) {
            return new Pair<>(null, 0);
        }

        Pair<TreeNode, Integer> left = dfs(root.left);
        Pair<TreeNode, Integer> right = dfs(root.right);

        if (left.getValue() > right.getValue()) {
            return new Pair<>(left.getKey(), left.getValue() + 1);
        }
        if (left.getValue() < right.getValue()) {
            return new Pair<>(right.getKey(), right.getValue() + 1);
        }
        return new Pair<>(root, left.getValue() + 1);
    }

    private TreeNode getTreeNode_ancestorSearch(TreeNode root) {
        Set<TreeNode> deepestLeaves = getDeepestLeaves(root);
        TreeNode ancestor = root;
        while(true){
            if(ancestor.left != null &&
                    isAncestor(ancestor.left, deepestLeaves)){
                ancestor = ancestor.left;
            }else if(ancestor.right != null &&
                    isAncestor(ancestor.right, deepestLeaves)){
                ancestor = ancestor.right;
            }else{
                break;
            }
        }
        return ancestor;
    }

    private boolean isAncestor(TreeNode root, Set<TreeNode> nodes) {
        Set<TreeNode> leaves = getLeaves(root);
        return leaves.containsAll(nodes);
    }

    private Set<TreeNode> getLeaves(TreeNode root) {
        Set<TreeNode> leaves = new HashSet<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode currNode = queue.poll();
            if(currNode.left == null && currNode.right == null) {
                leaves.add(currNode);
            }
            if(currNode.right != null) queue.add(currNode.right);
            if(currNode.left != null) queue.add(currNode.left);
        }
        return leaves;
    }

    private Set<TreeNode> getDeepestLeaves(TreeNode root) {
        Set<TreeNode> deepestLeaves = new HashSet<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        deepestLeaves.add(root);
        while(!queue.isEmpty()){
            Set<TreeNode> candidate = new HashSet<>();
            int n = queue.size();
            for(int i = 0; i < n; i++){
                TreeNode node = queue.poll();
                if(node.left != null) {
                    queue.add(node.left);
                    candidate.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                    candidate.add(node.right);
                }
            }
            if(!candidate.isEmpty()) deepestLeaves = candidate;
        }
        return deepestLeaves;
    }

    public static void main(String[] args) {
        Integer[] nodes = {3,5,1,6,2,0,8,null,null,7,4};
        TreeNode root = TreeNode.fromArray(nodes);
        LowestCommonAncestor_1123 sol = new LowestCommonAncestor_1123();
        System.out.println(sol.lcaDeepestLeaves(root));
    }

}
