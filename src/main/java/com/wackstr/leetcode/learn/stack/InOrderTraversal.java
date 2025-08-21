package com.wackstr.leetcode.learn.stack;

import com.wackstr.leetcode.structure.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class InOrderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if(root != null){
            dfs(root, ans);
        }
        return ans;

    }

    private void dfs(TreeNode node, List<Integer> ans) {
        if(node == null) return;
        dfs(node.left, ans);
        ans.add(node.val);
        dfs(node.right, ans);
    }
}
