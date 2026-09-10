package com.wackstr.leetcode;

import com.wackstr.leetcode.structure.TreeNode;

/*
2026-09-10 2265
 */
public class SubtreeAverage_2265 {
    int result = 0;

    public int averageOfSubtree(TreeNode root) {
        solve(root);

        return result;
    }

    private int[] solve(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int sum = 0;
        int count = 0;
        int[] left = solve(root.left);
        int[] right = solve(root.right);
        sum += left[0] + right[0] + root.val;
        count += left[1] + right[1] + 1;
        if (sum / count == root.val) {
            result++;
        }
        return new int[]{sum, count};
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.fromArray(new Integer[]{1});
        SubtreeAverage_2265 sol = new SubtreeAverage_2265();
        System.out.println(sol.averageOfSubtree(root));
    }
}
