package com.wackstr.leetcode;

/*
2026-01-22
 */
public class PairRemoval_3507 {
    public int minimumPairRemoval(final int[] nums) {
        int n = nums.length, count = 0;

        while(n > 1) {
            int minSum = Integer.MAX_VALUE, minIdx = -1;
            boolean decreasing = true;

            for(int i = 1; i < n; ++i) {
                if(nums[i - 1] + nums[i] < minSum) {
                    minSum = nums[i - 1] + nums[i];
                    minIdx = i - 1;
                }

                if(nums[i - 1] > nums[i])
                    decreasing = false;
            }

            if(decreasing)
                return count;

            nums[minIdx] = minSum;

            for(int i = minIdx + 1; i < n - 1; ++i)
                nums[i] = nums[i + 1];

            count++;
            n--;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,-1,3,-2,2,1,1,1,0,-1};
        PairRemoval_3507 sol = new PairRemoval_3507();
        System.out.println(sol.minimumPairRemoval(nums));
    }
}
