package com.wackstr.leetcode;

public class ZeroSubArrays_2348 {
    public long zeroFilledSubarray(int[] nums){
        long res = 0;
        int left = 0;
        int right;
        while(left < nums.length) {
            while (left < nums.length && nums[left] != 0) {
                left++;
            }
            right = left;
            while (right < nums.length && nums[right] == 0) {
                right++;
            }
            int k = (right - left);
            res += ((long) k *(k+1))/2;
            left = right;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 0, 0, 2, 0, 0, 4};
        ZeroSubArrays_2348 sol = new ZeroSubArrays_2348();
        System.out.println(sol.zeroFilledSubarray(nums));
    }
}
