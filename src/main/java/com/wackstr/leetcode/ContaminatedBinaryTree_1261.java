package com.wackstr.leetcode;

import com.wackstr.leetcode.structure.TreeNode;

import java.util.HashSet;
import java.util.Set;

/*
2025-02-21
 */
public class ContaminatedBinaryTree_1261 {
    private static class FindElements{

        private final Set<Integer> vals;

        public FindElements(TreeNode root){
            vals = new HashSet<>();
            init(root, 0, vals);

        }

        private void init(TreeNode root, int currValue, Set<Integer> vals) {
            root.val = currValue;
            vals.add(currValue);
            if(root.left != null) {
                int leftVal = 2 * currValue + 1;
                init(root.left, leftVal, vals);
            }
            if(root.right != null) {
                int rightVal = 2 * currValue + 2;
                init(root.right, rightVal, vals);
            }
        }

        public boolean find(int target){
            return vals.contains(target);
        }
    }

    public static void main(String[] args) {
        Integer[] nodes = {-1, null, -1};
        TreeNode root = TreeNode.fromArray(nodes);

        FindElements fn = new FindElements(root);
        System.out.println(fn.find(1));
        System.out.println(fn.find(2));

    }
}
