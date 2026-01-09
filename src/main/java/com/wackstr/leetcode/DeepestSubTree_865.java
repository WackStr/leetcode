package com.wackstr.leetcode;

import com.wackstr.leetcode.structure.TreeNode;

/*
2026-09-01 865
 */
public class DeepestSubTree_865 {

    private static class Result {
        TreeNode node;
        int dist;
        Result(TreeNode n, int d) {
            node = n;
            dist = d;
        }
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }

    // Return the result of the subtree at this node.
    public Result dfs(TreeNode node) {
        if (node == null) return new Result(null, 0);
        Result L = dfs(node.left),
                R = dfs(node.right);
        if (L.dist > R.dist) return new Result(L.node, L.dist + 1);
        if (L.dist < R.dist) return new Result(R.node, R.dist + 1);
        return new Result(node, L.dist + 1);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.fromArray(new Integer[]{0,1,3,null,2});
        DeepestSubTree_865 sol = new DeepestSubTree_865();
        System.out.println(sol.subtreeWithAllDeepest(root));
    }
}
