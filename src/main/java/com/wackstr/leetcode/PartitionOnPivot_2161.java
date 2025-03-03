package com.wackstr.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;

/*
2025-03-03
 */
public class PartitionOnPivot_2161 {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] ans = new int[nums.length];
        int lessI = 0;
        int greaterI = nums.length - 1;
        for (int i = 0, j = nums.length - 1; i < nums.length; i++, j--) {
            if (nums[i] < pivot) {
                ans[lessI] = nums[i];
                lessI++;
            }
            if (nums[j] > pivot) {
                ans[greaterI] = nums[j];
                greaterI--;
            }
        }
        while (lessI <= greaterI) {
            ans[lessI] = pivot;
            lessI++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = {9,12,5,10,14,3,10}, pivot = 10;
        PartitionOnPivot_2161 sol = new PartitionOnPivot_2161();
        System.out.println(Arrays.toString(sol.pivotArray(nums, pivot)));
    }
}
