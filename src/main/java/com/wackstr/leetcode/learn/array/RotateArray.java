package com.wackstr.leetcode.learn.array;

import java.util.Arrays;

public class RotateArray {
    public void rotate(int[] nums, int k){
        if(k != 0){
            k %= nums.length;
            rev(nums, 0, nums.length - 1);
            rev(nums, 0, k - 1);
            rev(nums, k, nums.length - 1);
        }

    }

    public void rev(int[] nums, int left, int right){
        while(left < right){
            int temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1, -100, 3, 99};
        int k = 2;
        RotateArray sol = new RotateArray();
        System.out.println(Arrays.toString(nums));
        sol.rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }
}
