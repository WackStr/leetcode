package com.wackstr.leetcode;

import com.wackstr.leetcode.structure.TreeNode;

/*
2026-02-24 1022
 */
public class TreeBinarySum_1022 {
    private int sum = 0;
    public int sumRootToLeaf(TreeNode root){
        dfs(0, root);
        return sum;
    }

    private void dfs(int val, TreeNode node) {
        int nexVal = (val << 1) | node.val;
        if(node.left == null && node.right == null) sum += nexVal;
        else{
            if(node.left != null) dfs(nexVal, node.left);
            if(node.right != null) dfs(nexVal, node.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.fromArray(new Integer[]{0});
        TreeBinarySum_1022 sol = new TreeBinarySum_1022();
        System.out.println(sol.sumRootToLeaf(root));
    }
}
