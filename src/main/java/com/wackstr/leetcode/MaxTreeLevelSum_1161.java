package com.wackstr.leetcode;

import com.wackstr.leetcode.structure.TreeNode;

import java.util.ArrayDeque;

/*
2025-01-06 1161
 */
public class MaxTreeLevelSum_1161 {

    public int maxLevelSum(TreeNode root){
        int minLevel = Integer.MAX_VALUE;
        int maxSum = Integer.MIN_VALUE;
        int currLevel = 0;
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();

        stack.addLast(root);

        while(!stack.isEmpty()){
            currLevel++;
            int n = stack.size();
            int currSum = 0;

            while(n > 0){
                TreeNode curr = stack.pollFirst();
                currSum += curr.val;
                if(curr.left != null) stack.addLast(curr.left);
                if(curr.right != null) stack.addLast(curr.right);
                n--;
            }

            if(currSum > maxSum){
                maxSum = currSum;
                minLevel = currLevel;
            }
        }

        return minLevel;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.fromArray(new Integer[]{989,null,10250,98693,-89388,null,null,null,-32127});
        MaxTreeLevelSum_1161 sol = new MaxTreeLevelSum_1161();
        System.out.println(sol.maxLevelSum(root));
    }
}
