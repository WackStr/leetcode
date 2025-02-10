package com.wackstr.leetcode;

import java.util.Arrays;

/*
2024-11-16
 */
public class ArrayPower_3254 {

    public int[] resultsArray(int[] nums, int k){        int left = 0;
        return processSlidingWindow(nums, k, left);
    }

    private int[] processSlidingWindow(int[] nums, int k, int left) {
        int right = 1;
        int[] ans = new int[nums.length - k + 1];
        while (right < nums.length) {
            if(nums[right] != nums[right - 1] + 1){
                // process this range
                processRange(left, right, k, nums, ans);
                left = right;
            }
            right++;
        }
        processRange(left, right, k, nums, ans);
        return ans;
    }

    public void processRange( int left, int right, int k, int[] nums, int[] ans){
        for(int i = left; i < right && i < ans.length; i++) {
            if(i <= right - k) {
                ans[i] = nums[i + k - 1];
            }else{
                ans[i] = -1;
            }
        }
    }

    private int[] resultArrayBrute(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        int left = 0;
        int right = left + k - 1;
        while(right < nums.length){
            if(isSorted(nums, left, right)){
                ans[left] = nums[right];
            }else{
                ans[left] = -1;
            }
            left++;
            right++;
        }
        return ans;
    }

    private boolean isSorted(int[] nums, int left, int right) {
        for(int i = left; i < right; i++){
            if(nums[i] != nums[i+1] - 1) return false;
        }
        return true;
    }


    public static void main(String[] args) {
        int[] nums = {3,2,3,2,3,2};
        int k = 2;
        ArrayPower_3254 sol = new ArrayPower_3254();
        System.out.println(Arrays.toString(sol.resultsArray(nums, k)));
    }
}
