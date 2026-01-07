package com.wackstr.leetcode;

import com.wackstr.leetcode.structure.TreeNode;

/*
2026-01-07 1339
 */
public class BinaryTreeProduct_1339 {
    long total = 0;
    long max = 0;

    public int maxProduct(TreeNode root) {
        total = transform(root);
        help(root);
        return (int)(max % 1_000_000_007);
    }

    public long transform(TreeNode root) {
        if (root == null) return 0;

        long l = transform(root.left);
        long r = transform(root.right);

        root.val = (int)(l + r + root.val); // value itself fits int
        return root.val;
    }

    public void help(TreeNode root) {
        if (root == null) return;

        if (root.left != null) {
            max = Math.max(max,
                    (long) root.left.val * (total - root.left.val));
        }

        if (root.right != null) {
            max = Math.max(max,
                    (long) root.right.val * (total - root.right.val));
        }

        help(root.left);
        help(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.fromArray(new Integer[]{1,2,3,4,5,6});
        BinaryTreeProduct_1339 sol = new BinaryTreeProduct_1339();
        System.out.println(sol.maxProduct(root));
    }
}
