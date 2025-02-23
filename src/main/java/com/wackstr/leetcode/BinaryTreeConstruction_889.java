package com.wackstr.leetcode;

import com.wackstr.leetcode.structure.TreeNode;

/*
2025-02-23
 */
public class BinaryTreeConstruction_889 {

    private int preIndex = 0;
    private int postIndex = 0;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return constructTree(preorder, postorder);
    }

    // Helper function to recursively build the tree
    private TreeNode constructTree(int[] preorder, int[] postorder) {
        // Create a new node with the value at the current preorder index
        TreeNode root = new TreeNode(preorder[preIndex++]);

        // Recursively construct the left subtree if the root is not the last of
        // its subtree
        if (root.val != postorder[postIndex]) {
            root.left = constructTree(preorder, postorder);
        }

        // Recursively construct the right subtree if the root is still not the
        // last of its subtree
        if (root.val != postorder[postIndex]) {
            root.right = constructTree(preorder, postorder);
        }

        // Mark this node and its subtree as fully processed
        postIndex++;
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {1,2,4,5,3,6,7};
        int[] postorder = {4,5,2,6,7,3,1};
        BinaryTreeConstruction_889 sol = new BinaryTreeConstruction_889();
        System.out.println(sol.constructFromPrePost(preorder, postorder));
    }
}
