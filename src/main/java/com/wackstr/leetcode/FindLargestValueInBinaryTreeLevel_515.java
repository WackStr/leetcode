package com.wackstr.leetcode;

import com.wackstr.leetcode.structure.TreeNode;

import java.util.*;

/*
2024-12-25
 */
public class FindLargestValueInBinaryTreeLevel_515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> levelMax = new ArrayList<>();
        if (root != null) {
            Queue<TreeNode> currLevel = new ArrayDeque<>();
            currLevel.add(root);
            while (!currLevel.isEmpty()) {
                int n = currLevel.size();
                int max = Integer.MIN_VALUE;
                for(int i = 0; i < n; i++){
                    TreeNode currNode = currLevel.poll();
                    max = Math.max(max, currNode.val);
                    if(currNode.left != null) currLevel.add(currNode.left);
                    if(currNode.right != null) currLevel.add(currNode.right);
                }
                levelMax.add(max);
            }
        }
        return levelMax;
    }

    public static void main(String[] args) {
        Integer[] rootArray = {1,3,2,5,3,null,9};
        TreeNode root = TreeNode.fromArray(rootArray);
        FindLargestValueInBinaryTreeLevel_515 sol = new FindLargestValueInBinaryTreeLevel_515();
        System.out.println(sol.largestValues(root));
    }
}
