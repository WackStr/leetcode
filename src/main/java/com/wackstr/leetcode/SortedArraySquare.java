package com.wackstr.leetcode;

import java.util.Arrays;

public class SortedArraySquare {
    public int[] sortedSquares(int[] nums){
        int n = nums.length;
        int[] squaredArray = new int[nums.length];
        int left = 0;
        int right = n - 1;
        int currIndex = n - 1;
        while(left <= right){
            boolean chooseLeft = Math.abs(nums[left]) > Math.abs(nums[right]);
            int currNumber = chooseLeft ?
                    square(nums, left) : square(nums, right);
            if(chooseLeft) left++;
            else right--;

            squaredArray[currIndex] = currNumber;
            currIndex--;
        }
        return squaredArray;
    }

    private int square(int[] nums, int index) {
        return nums[index] * nums[index];
    }

    public static void main(String[] args) {
        int[] nums = {-7, -3, 2, 3, 11};
        SortedArraySquare sol = new SortedArraySquare();
        System.out.println(Arrays.toString(sol.sortedSquares(nums)));
    }
}
