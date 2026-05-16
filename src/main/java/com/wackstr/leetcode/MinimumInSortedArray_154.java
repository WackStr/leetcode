package com.wackstr.leetcode;

/*
2026-05-16
 */
public class MinimumInSortedArray_154 {
    public int findMin(int[] nums) {
        if(nums[nums.length - 1] > nums[0]) return nums[0];
        return search(nums, 0, nums.length-1);
    }

    private int search(int[] nums, int left, int right) {
        if(left == right) return nums[left];
        while(left < right - 1 && nums[left + 1] == nums[left]) left++;
        while(right > left && nums[right-1] == nums[right]) right--;
        int mid = left + (right - left) / 2;
        if(mid == left) return Math.min(nums[left], nums[right]);
        if(nums[mid] >= nums[0]) return search(nums, mid, right);
        else return search(nums, left, mid);
    }

    public static void main(String[] args) {
        int[] nums = {10, 1, 10, 10, 10};
        MinimumInSortedArray_154 sol = new MinimumInSortedArray_154();
        System.out.println(sol.findMin(nums));
    }
}
