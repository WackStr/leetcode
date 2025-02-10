package com.wackstr.leetcode.klevelsum;

import com.wackstr.leetcode.structure.TreeNode;

import java.util.*;

public class KLevelSumPriorityQueue extends KLevelSum{

    @Override
    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> sums = new PriorityQueue<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while(!queue.isEmpty()){
            long sum = 0;
            int queueSize = queue.size();
            for(int i = 0; i < queueSize; i++){
                TreeNode node = queue.remove();
                sum += node.val;
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            sums.add(sum);
            if(sums.size() > k){
                sums.remove();
            }
        }
        if(sums.size() < k) return -1;
        return sums.peek();
    }
}
