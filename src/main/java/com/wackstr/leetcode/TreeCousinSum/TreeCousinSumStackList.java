package com.wackstr.leetcode.TreeCousinSum;

import com.wackstr.leetcode.structure.TreeNode;

import java.util.*;

public class TreeCousinSumStackList extends TreeCousinSum {

    @Override
    public TreeNode replaceValueInTree(TreeNode root) {
        Deque<List<TreeNode>> sameLevelSiblingGroups = new ArrayDeque<>();
        sameLevelSiblingGroups.add(List.of(root));
        while(!sameLevelSiblingGroups.isEmpty()){
            int levelSize = sameLevelSiblingGroups.size();
            int levelSum = sumNodeCollections(sameLevelSiblingGroups);
            for (int i = 0; i < levelSize; i++) {
                List<TreeNode> siblingNodes = sameLevelSiblingGroups.pop();
                int siblingGroupSum = siblingNodes.stream().mapToInt(t -> t.val).sum();
                int cousinSum = levelSum - siblingGroupSum;
                for (TreeNode tn : siblingNodes) {
                    List<TreeNode> childNodes = new ArrayList<>();
                    tn.val = cousinSum;
                    if (tn.left != null){
                        childNodes.add(tn.left);
                    }
                    if (tn.right != null){
                        childNodes.add(tn.right);
                    }
                    if(!childNodes.isEmpty()){
                        sameLevelSiblingGroups.add(childNodes);
                    }
                }
            }
        }
        return root;
    }

    private int sumNodeCollections(
            Collection<? extends Collection<TreeNode>> nodes){
        return  nodes.stream()
                .flatMap(t -> t.stream().map(v -> v.val))
                .reduce(0, Integer::sum);
    }
}
