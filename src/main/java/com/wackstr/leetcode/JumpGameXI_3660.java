package com.wackstr.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
2026-05-07 3660
 */
public class JumpGameXI_3660 {

    private static class DSU{
        private final int[] parents;
        private final int[] runningMax;
        private final int[] size;

        public DSU(int[] nums){
            parents = new int[nums.length];
            runningMax = new int[nums.length];
            size = new int[nums.length];
            for (int i = 0; i < parents.length; i++) {
                parents[i] = i;
                runningMax[i] = nums[i];
                size[i] = 1;
            }
        }

        public void union(int i, int j){
            int parenti = find(i);
            int parentj = find(j);
            if(parenti == parentj) return;
            if(size[parenti] > size[parentj]){
                int temp = parenti;
                parenti = parentj;
                parentj = temp;
            }
            parents[parenti] = parentj;
            size[parentj] += size[parenti];
            runningMax[parentj] = Math.max(runningMax[parentj], runningMax[parenti]);
        }

        public int find(int i){
            if(i != parents[i]){
                int parent = find(parents[i]);
                parents[i] = parent;
                return parent;
            }else {
                return i;
            }
        }

        public int getMax(int i){
            return runningMax[find(i)];
        }

    }
    public int[] maxValue(int[] nums) {
        int n = nums.length, min = Integer.MAX_VALUE;
        int[] max = new int[n], ans = new int[n];
        max[0] = nums[0];
        for(int i = 1; i < n; i++) max[i] = Math.max(max[i - 1], nums[i]);

        for(int i = n - 2; i >= 0; i--) {
            min = Math.min(min, nums[i + 1]);
            if(min < max[i]) max[i] = max[i + 1];
        }
        return max;
    }

    private static int[] getMaxValueDSU(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        DSU set = new DSU(nums);
        List<Integer> queue = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            for(int j = queue.size() - 1; j >= 0 && nums[queue.get(j)] <= nums[i]; j--){
                set.union(i, queue.get(j));
            }
            if(queue.isEmpty() || nums[queue.get(queue.size()-1)] >= nums[i] ){
                queue.add(i);
            }
        }
        for (int i = 0; i < res.length; i++) {
            res[i] = set.getMax(i);
        }
        return res;
    }

    private static int[] getMaxTwoJumps(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int[] prefix = new int[n];
        List<Integer> queue = new ArrayList<>();
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = Math.max(nums[i], prefix[i-1]);
        }
        for (int i = n - 1; i >= 0; i--) {
            res[i] = prefix[i];
            for(int j = queue.size() - 1; j >= 0 && nums[queue.get(j)] < nums[i]; j--){
                res[i] = Math.max(res[i], prefix[queue.get(j)]);
            }
            if(queue.isEmpty() || nums[queue.get(queue.size()-1)] > nums[i]) queue.add(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {30,21,5,35,24};
        JumpGameXI_3660 sol = new JumpGameXI_3660();
        System.out.println(Arrays.toString(sol.maxValue(nums)));
    }
}
