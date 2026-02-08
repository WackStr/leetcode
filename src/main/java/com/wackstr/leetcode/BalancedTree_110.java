package com.wackstr.leetcode;

import com.wackstr.leetcode.structure.TreeNode;


/*
2026-02-08 110
 */
public class BalancedTree_110 {

    public boolean isBalanced(TreeNode root) {
        return dfsHeight(root) != -1;
    }

    private int dfsHeight(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = dfsHeight(node.left);
        if (leftHeight == -1) return -1;

        int rightHeight = dfsHeight(node.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        TreeNode node = TreeNode.fromArray(new Integer[]{1, 2, 2, 3, null, null, 3, 4, null, null, 4});
        BalancedTree_110 sol = new BalancedTree_110();
        System.out.println(sol.isBalanced(node));
    }
}
