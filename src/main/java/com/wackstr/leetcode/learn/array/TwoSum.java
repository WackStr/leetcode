package com.wackstr.leetcode.learn.array;

import java.util.Arrays;

public class TwoSum {


    /*
    Given a 1-indexed array of integers numbers that is already sorted in
    non-decreasing order, find two numbers such that they add up to a specific
    target number. Let these two numbers be numbers[index1] and
    numbers[index2] where 1 <= index1 < index2 <= numbers.length.

    Return the indices of the two numbers, index1 and index2, added by one as
    an integer array [index1, index2] of length 2.

    The tests are generated such that there is exactly one solution. You may
    not use the same element twice.

    Your solution must use only constant extra space.
     */
    public int[] twoSum(int[] numbers, int target){
        int left = 0;
        int right = numbers.length - 1;
        while(left < right){
            while(right > left && numbers[left] + numbers[right] > target)
                right--;
            if(numbers[left] + numbers[right] == target)
                return new int[]{left + 1, right + 1};
            left++;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] numbers = {-1, 0};
        int target = -1;
        TwoSum sol = new TwoSum();
        System.out.println(Arrays.toString(sol.twoSum(numbers, target)));
    }
}
