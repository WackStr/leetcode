package com.wackstr.leetcode;

/*
2026-05-22 33
 */
public class SearchRotatedArray_33 {
    public int search(int[] nums, int target){
        return search(nums, target, 0, nums.length - 1);
    }

    private int search(int[] nums, int target, int left, int right) {
        if(right - left <= 1){
            if(nums[right] == target) return right;
            else if (nums[left] == target) return left;
            else return -1;
        }
        int mid = left + (right - left)/2;
        if(nums[mid] == target) return mid;
        if(nums[left] > nums[right]) {
            return Math.max(search(nums, target, left, mid), search(nums, target, mid, right));
        }else{
            if(target < nums[left] || target > nums[right]) return -1;
            if(nums[mid] < target) return search(nums, target, mid, right);
            else return search(nums, target, left, mid);
        }
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        SearchRotatedArray_33 sol = new SearchRotatedArray_33();
        System.out.println(sol.search(nums, target));
    }
}
