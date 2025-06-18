package com.wackstr.leetcode;

import java.util.Arrays;

/*
2025-06-18
 */
public class ArrayTriplets_2966 {

    public int[][] divideArray(int[] nums, int k){
        Arrays.sort(nums);
        int[][] res = new int[nums.length/3][];
        int index = 0;
        int finalIndex = nums.length - 3 + 1;
        for(int i = 0; i < finalIndex; i += 3){
            if(nums[i+2] - nums[i] <= k){
                res[index] = new int[]{nums[i], nums[i+1], nums[i+2]};
                index++;
            }else{
                return new int[0][];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,4,8,7,9,3,5,1};
        int k = 2;
        ArrayTriplets_2966 sol = new ArrayTriplets_2966();
        System.out.println(Arrays.deepToString(sol.divideArray(nums, k)));
    }
}
