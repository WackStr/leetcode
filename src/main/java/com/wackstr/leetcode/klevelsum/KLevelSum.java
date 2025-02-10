package com.wackstr.leetcode.klevelsum;

import com.wackstr.leetcode.structure.TreeNode;

public abstract class KLevelSum {

    public abstract long kthLargestLevelSum(TreeNode root, int k);


    public static void main(String[] args) {
        Integer[] array = {5,8,9,2,1,3,7,4,6};
        TreeNode root =  TreeNode.fromArray(array);
        System.out.println(root);

        KLevelSum sol = new KLevelSumPriorityQueue();
        long sum = sol.kthLargestLevelSum(root, 2);

        System.out.println(sum);
    }


}
