package com.wackstr.leetcode;

/*
2025-07-25
 */
public class MaximumSubArray_3487 {
    public int maxSum(int[] nums){
        int[] cnt = new int[201];
        for (int num : nums) {
            cnt[num + 100] = 1;
        }
        int res = 0;
        for (int i = 200; i > 100; i--) {
            res += (i - 100) * cnt[i];
        }
        if(res == 0 && cnt[100] == 0){
            for (int i = 99; i >= 0 ; i--) {
                if(cnt[i] == 1){
                    res = i - 100;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,-1,-2,1,0,-1};
        MaximumSubArray_3487 sol = new MaximumSubArray_3487();
        System.out.println(sol.maxSum(nums));
    }
}
