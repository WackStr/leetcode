package com.wackstr.leetcode;

import com.wackstr.leetcode.structure.TreeNode;

import java.util.*;

/*
2024-12-23
 */
public class SwapSortBinaryLevels_2471 {
    public int minimumOperations(TreeNode root){
        int totalCnt = 0;
        Queue<TreeNode> currLevel = new ArrayDeque<>();
        currLevel.add(root);
        while(!currLevel.isEmpty()) {
            int n = currLevel.size();
            int[] lvl = new int[n];
            for (int i = 0; i < n; i++) {
                TreeNode currNode = currLevel.poll();
                lvl[i] = currNode.val;
                if (currNode.left != null) currLevel.add(currNode.left);
                if (currNode.right != null) currLevel.add(currNode.right);
            }
            totalCnt += getSwapCounts(lvl);
        }
        return totalCnt;
    }

    private int getSwapCounts(int[] lvl) {
        int cnt = 0;
        int[] lvl2 = lvl.clone();
        Arrays.sort(lvl2);
        Map<Integer, Integer> lookup = new HashMap<>();
        for(int i = 0; i < lvl2.length; i++){
            lookup.put(lvl2[i], i);
        }
        for(int i = 0; i < lvl.length; i++){
            while(lvl[i] != lvl2[i]){
                int index = lookup.get(lvl[i]); // findIndex(lvl2, lvl.get(i), i);
                int temp = lvl[index];
                lvl[index] = lvl[i];
                lvl[i] = temp;
                cnt++;
            }
        }
        return cnt;
    }

    private int findIndex(List<Integer> ls, Integer val, int left) {
        int right = ls.size() - 1;
        while(left < right){
            int mid = left + ((right - left) >> 1);
            if(ls.get(mid).equals(val)) return mid;
            else if(ls.get(mid) > val) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }

    public static void main(String[] args) {
        Integer[] rootArray = {1,3,2,7,6,5,4};
        TreeNode root = TreeNode.fromArray(rootArray);
        SwapSortBinaryLevels_2471 sol = new SwapSortBinaryLevels_2471();
        System.out.println(sol.minimumOperations(root));
    }
}
