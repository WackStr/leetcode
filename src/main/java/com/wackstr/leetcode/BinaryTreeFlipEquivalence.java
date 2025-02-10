package com.wackstr.leetcode;

import com.wackstr.leetcode.structure.TreeNode;

/*
2024-10-24
951. Flip Equivalent Binary Tree
 */
public class BinaryTreeFlipEquivalence {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null){
            return true;
        }else if (root1 == null || root2 == null){
            return false;
        }else{
            boolean currSame = root1.val == root2.val;
            if(!currSame) return false;

            boolean sameValLeft = equalNodes(root1.left, root2.left);
            boolean sameValRight = equalNodes(root1.right, root2.right);
            boolean noFlip = sameValLeft && sameValRight;

            boolean flipValLeft = equalNodes(root1.left, root2.right);
            boolean flipValRight = equalNodes(root1.right, root2.left);
            boolean flip = flipValLeft && flipValRight;

            if(noFlip){
                return flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
            }else if(flip){
                return flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
            }else{
                return false;
            }
        }
    }

    private boolean equalNodes(TreeNode node1, TreeNode node2){
        return (node1 == null && node2 == null) || (node1 != null && node2 !=null && node1.val == node2.val);
    }

    public static void main(String[] args) {
        Integer[] root1 = {1,2,3,4,5,6,null,null,null,7,8};
        Integer[] root2 = {99,3,2,null,6,4,5,null,null,null,null,8,7};
        BinaryTreeFlipEquivalence sol = new BinaryTreeFlipEquivalence();
        boolean ans = sol.flipEquiv(
                TreeNode.fromArray(root1),
                TreeNode.fromArray(root2));
        System.out.println(ans);
    }
}
