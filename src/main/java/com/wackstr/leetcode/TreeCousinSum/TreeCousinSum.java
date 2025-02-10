package com.wackstr.leetcode.TreeCousinSum;

import com.wackstr.leetcode.structure.TreeNode;

public abstract class TreeCousinSum {
    public abstract TreeNode replaceValueInTree(TreeNode root);

    public static void main(String[] args) {
        Integer[] sampleTree = {5,4,9,1,10,null,7};
        TreeNode tree = TreeNode.fromArray(sampleTree);
        TreeCousinSum sol = new TreeCousinSumStackList();
        TreeNode replacedTree = sol.replaceValueInTree(tree);
        System.out.println(replacedTree);
    }
}
