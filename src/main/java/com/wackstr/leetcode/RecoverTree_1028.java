package com.wackstr.leetcode;

import com.wackstr.leetcode.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/*
2025-02-22
 */
public class RecoverTree_1028 {
    private  record Node(int val, int level){}

    public TreeNode recoverFromPreorder(String traversal){
        Queue<Node> nodes = getNodes(traversal);
        Node rootNode = nodes.poll();
        TreeNode root = new TreeNode(rootNode.val);
        dfs(root, nodes, 0);
        return root;
    }

    private void dfs(TreeNode root, Queue<Node> nodes, int level) {
        if(!nodes.isEmpty()) {
            int nextLevel = nodes.peek().level;
            if(nextLevel == level + 1){
                root.left = new TreeNode(nodes.poll().val);
                dfs(root.left, nodes, level + 1);
            }
        }
        if(!nodes.isEmpty()){
            int nextLevel = nodes.peek().level;
            if(nextLevel == level + 1){
                root.right = new TreeNode(nodes.poll().val);
                dfs(root.right, nodes, level + 1);
            }
        }
    }

    public Queue<Node> getNodes(String traversal){
        Queue<Node> nodes = new ArrayDeque<>();
        int i = 0;
        while(i < traversal.length()){
            int level = 0;
            int val = 0;
            while(i < traversal.length() && traversal.charAt(i) == '-'){
                level++;
                i++;
            }
            while(i < traversal.length() && traversal.charAt(i) != '-'){
                val *= 10;
                val += traversal.charAt(i) - '0';
                i++;
            }
            nodes.add(new Node(val, level));
        }
        return nodes;
    }

    public static void main(String[] args) {
        String traversal = "1-401--349---90--88";
        RecoverTree_1028 sol = new RecoverTree_1028();
        System.out.println(sol.recoverFromPreorder(traversal));
    }
}
