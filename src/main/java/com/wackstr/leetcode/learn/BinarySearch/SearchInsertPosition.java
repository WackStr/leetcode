package com.wackstr.leetcode.learn.BinarySearch;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if(target <= nums[0]) return 0;
        if(target == nums[nums.length - 1]) return nums.length - 1;
        if(target > nums[nums.length - 1]) return nums.length;
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            if(right - left == 1) {
                return nums[left] == target ? left : left + 1;
            }
            int mid = left + (right - left)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] < target) left = mid;
            else right = mid;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7};
        int target = 8;
        SearchInsertPosition sol = new SearchInsertPosition();
        System.out.println(sol.searchInsert(nums, target));
    }
}
