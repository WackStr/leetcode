package com.wackstr.leetcode.klevelsum;

import com.wackstr.leetcode.structure.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KLevelSumSort extends KLevelSum {

    private record LevelSum (int level, long sum){}

    private record Scan(long levelSum, List<TreeNode> nextLevel){}

    @Override
    public long kthLargestLevelSum(TreeNode root, int k) {
        if (root != null) {
            List<LevelSum> levelSums = new ArrayList<>();
            int level = 1;
            Scan scan = aggregate(List.of(root));
            levelSums.add(new LevelSum(level, scan.levelSum()));
            while (!scan.nextLevel().isEmpty()) {
                level++;
                scan = aggregate(scan.nextLevel());
                levelSums.add(new LevelSum(level, scan.levelSum()));
            }
            levelSums.sort(Comparator.comparingLong(LevelSum::sum).reversed());
            if (k <= levelSums.size()) {
                return levelSums.get(k - 1).sum();
            } else {
                return -1;
            }
        } else {
            return 0;
        }
    }

    private Scan aggregate(List<TreeNode> root) {
        long sum = 0;
        List<TreeNode> next = new ArrayList<>();
        for(TreeNode node: root){
            sum += node.val;
            if (node.left != null){
                next.add(node.left);
            }
            if (node.right != null){
                next.add(node.right);
            }
        }
        return new Scan(sum, next);
    }
}
