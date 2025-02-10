package com.wackstr.leetcode;

import com.wackstr.leetcode.structure.TreeNode;

import java.util.ArrayDeque;

/*
2024-12-20
 */
public class ReverseOddLevels_2415 {

    public TreeNode reverseOddLevels(TreeNode root) {
        ArrayDeque<TreeNode> firstLayer = new ArrayDeque<>();
        firstLayer.add(root);

        while(!firstLayer.isEmpty()){
            ArrayDeque<TreeNode> secondLayer = new ArrayDeque<>();
            ArrayDeque<TreeNode> thirdLayer = new ArrayDeque<>();
            int n = firstLayer.size();
            for(int i = 0; i < n; i++){
                TreeNode currNode = firstLayer.poll();
                if(currNode.left != null){
                    secondLayer.add(currNode.left);
                    secondLayer.add(currNode.right);
                    if(currNode.left.left != null){
                        thirdLayer.add(currNode.left.left);
                        thirdLayer.add(currNode.left.right);
                        thirdLayer.add(currNode.right.left);
                        thirdLayer.add(currNode.right.right);
                    }
                }
                firstLayer.add(currNode);
            }
            while(!firstLayer.isEmpty()){
                TreeNode currNode = firstLayer.pollFirst();
                if(!secondLayer.isEmpty()){
                    TreeNode leftNode = secondLayer.pollLast();
                    TreeNode rightNode = secondLayer.pollLast();
                    currNode.left = leftNode;
                    currNode.right = rightNode;
                    if(!thirdLayer.isEmpty()){
                        TreeNode leftLeftNode = thirdLayer.pollFirst();
                        TreeNode leftRightNode = thirdLayer.pollFirst();
                        TreeNode rightLeftNode = thirdLayer.pollFirst();
                        TreeNode rightRightNode = thirdLayer.pollFirst();
                        leftNode.left = leftLeftNode;
                        leftNode.right = leftRightNode;
                        rightNode.left = rightLeftNode;
                        rightNode.right = rightRightNode;
                        thirdLayer.addLast(leftLeftNode);
                        thirdLayer.addLast(leftRightNode);
                        thirdLayer.addLast(rightLeftNode);
                        thirdLayer.addLast(rightRightNode);
                    }
                }
            }
            firstLayer = thirdLayer;
        }
        return root;
    }

    public TreeNode reverseOddLevels_DFS(TreeNode root){
        traverseDFS(root.left, root.right, 0);
        return root;
    }

    private void traverseDFS(
            TreeNode leftChild,
            TreeNode rightChild,
            int level
    ) {
        if (leftChild == null || rightChild == null) {
            return;
        }
        //If the current level is odd, swap the values of the children.
        if (level % 2 == 0) {
            int temp = leftChild.val;
            leftChild.val = rightChild.val;
            rightChild.val = temp;
        }

        traverseDFS(leftChild.left, rightChild.right, level + 1);
        traverseDFS(leftChild.right, rightChild.left, level + 1);
    }

    public static void main(String[] args) {
        int n = 4;
        int cnt = (1 << n) - 1;
        Integer[] points = new Integer[cnt];
        for(int i = 0; i < cnt; i++){
            points[i] = i;
        }
        TreeNode root = TreeNode.fromArray(points);
        ReverseOddLevels_2415 sol = new ReverseOddLevels_2415();
        System.out.println(root);
        System.out.println(sol.reverseOddLevels(root));
    }
}