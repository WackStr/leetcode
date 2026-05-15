package com.wackstr.leetcode;

/*
2026-05-15 153
 */
public class MinimumInSortedArray_153 {
    public int findMin(int[] nums) {
        if(nums[nums.length - 1] > nums[0]) return nums[0];
        return search(nums, 0, nums.length-1);
    }

    private int search(int[] nums, int left, int right) {
        if(left == right) return nums[left];
        int mid = left + (right - left) / 2;
        if(mid == left) return Math.min(nums[left], nums[right]);
        if(nums[mid] > nums[0]) return search(nums, mid, right);
        else return search(nums, left, mid);
    }

    public static void main(String[] args) {
        int[] nums = {5,1,2,3,4};
        MinimumInSortedArray_153 sol = new MinimumInSortedArray_153();
        System.out.println(sol.findMin(nums));
    }
}
