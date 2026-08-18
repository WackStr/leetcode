package com.wackstr.leetcode;

/*
2026-08-18 3471
 */
public class AlmostMissing_3471 {
    public int largestInteger(int[] nums, int k) {
        if(k == nums.length){
            int res = -1;
            for (int num : nums) {
                res = Math.max(res, num);
            }
            return res;
        }
        if(k==1){
            int[] cnt = new int[51];
            for (int num : nums) {
                cnt[num]++;
            }
            for (int i = cnt.length - 1; i >= 0; i--) {
                if(cnt[i] == 1) return i;
            }
            return -1;
        }
        if(nums[0] == nums[nums.length - 1]) return -1;
        int a = nums[0];
        int b = nums[nums.length - 1];
        for (int i = 1; i < nums.length - 1; i++) {
            if(nums[i] == a) a = -1;
            if(nums[i] == b) b = -1;
        }
        return Math.max(a,b);
    }

    public static void main(String[] args) {
        int[] nums = {3, 9, 2, 1, 7};
        int k = 3;
        AlmostMissing_3471 sol = new AlmostMissing_3471();
        System.out.println(sol.largestInteger(nums, k));
    }
}
