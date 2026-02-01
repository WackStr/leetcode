package com.wackstr.leetcode;

/*
2026-02-01 3010
 */
public class SubArrays_3010 {
    public int minimumCost(int[] nums) {
        int a = nums[0];
        int b = Integer.MAX_VALUE;
        int c = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if(num < b){
                c = b;
                b = num;
            }else if(num < c){
                c = num;
            }
        }
        return a + b + c;
    }

    public static void main(String[] args) {
        int[] nums = {10, 3, 1, 1};
        SubArrays_3010 sol = new SubArrays_3010();
        System.out.println(sol.minimumCost(nums));
    }
}
