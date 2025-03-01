package com.wackstr.leetcode;

import java.util.Arrays;

/*
2025-03-01
 */
public class ArrayOperation_2460 {
    public int[] applyOperations(int[] nums){
        int n = nums.length;
        int[] shiftedArray = new int[n];
        int currIndex = 0;
        for(int i = 0; i < n - 1; i++){
            if(nums[i] == nums[i+1]) {
                nums[i] *= 2;
                nums[i+1] = 0;
            }
            if(nums[i] != 0){
                shiftedArray[currIndex++] = nums[i];
            }
        }
        if(nums[n-1] != 0){
            shiftedArray[currIndex] = nums[n-1];
        }
        return shiftedArray;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,4};
        ArrayOperation_2460 sol = new ArrayOperation_2460();
        System.out.println(Arrays.toString(sol.applyOperations(nums)));
    }


}
