package com.wackstr.leetcode;

/*
2025-09-30
 */
public class TriangularSum_2221 {
    public int triangularSum(int[] nums){
        if(nums.length == 1) return nums[0];
        int[] prev = nums;
        int[] next = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums.length - i  - 1; j++){
                next[j] = (prev[j] + prev[j+1]) % 10;
            }
            prev = next;
        }
        return next[0] % 10;
    }

    public static void main(String[] args) {
        int[] nums = {1,2};
        TriangularSum_2221 sol = new TriangularSum_2221();
        System.out.println(sol.triangularSum(nums));
    }
}
