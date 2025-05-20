package com.wackstr.leetcode;

/*
2025-05-20
 */
public class ZeroArrayTransformation_3355 {
    public boolean isZeroArray(int[] nums, int[][] queries){
        int[] diffArray = new int[nums.length+1];
        for(int[] query : queries){
            diffArray[query[0]]++;
            diffArray[query[1]+1]--;
        }
        for(int i = 1; i < nums.length; i++){
            diffArray[i] += diffArray[i-1];
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > diffArray[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 1};
        int[][] queries = {{1, 3}, {0, 2}};
        ZeroArrayTransformation_3355 sol = new ZeroArrayTransformation_3355();
        System.out.println(sol.isZeroArray(nums, queries));
    }
}
