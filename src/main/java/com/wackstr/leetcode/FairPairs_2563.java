package com.wackstr.leetcode;

import java.sql.SQLOutput;
import java.util.Arrays;

/*
2024-11-13
 */
public class FairPairs_2563 {

    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long count = 0;
        for(int i = 0; i < nums.length; i++) {
            int currNumber = nums[i];
            int upperBoundIndex = bisectGreatestLowerBound(nums, upper - currNumber, i, nums.length - 1);
            int lowerBoundIndex = bisectLeastUpperBound(nums, lower - currNumber, i, nums.length - 1);

            if(upperBoundIndex < nums.length && lowerBoundIndex <= upperBoundIndex) {
                count += addPairs(lowerBoundIndex, upperBoundIndex, i);
            }
        }
        return count;
    }

    private int bisectGreatestLowerBound(int[] nums, int target, int left, int right) {
        if(left >= right - 1) {
            if(nums[right] <= target) return right;
            if(nums[left] <= target) return left;
            return nums.length;
        }
        int mid = (left + right)/2;
        if(nums[mid] <= target) {
            left = mid;
        }else{
            right = mid;
        }
        return bisectGreatestLowerBound(nums, target, left, right);
    }

    private int bisectLeastUpperBound(int[] nums, int target, int left, int right) {
        if(left >= right - 1) {
            if(nums[left] >= target) return left;
            if(nums[right] >= target) return right;
            return nums.length;
        }
        int mid = (left + right)/2;
        if(nums[mid] >= target) {
            right = mid;
        }else{
            left = mid;
        }
        return bisectLeastUpperBound(nums, target, left, right);
    }

    private long addPairs(int lowerBoundIndex, int upperBoundIndex, int currIndex) {
        long totalCountInRange = upperBoundIndex - lowerBoundIndex + 1L;
        if(currIndexOverlapsRange(lowerBoundIndex, upperBoundIndex, currIndex)) totalCountInRange--;
        return totalCountInRange;
    }

    private boolean currIndexOverlapsRange(int lowerBoundIndex, int upperBoundIndex, int currIndex) {
        return currIndex >= lowerBoundIndex && currIndex <= upperBoundIndex;
    }

    public static void main(String[] args) {
        int[] nums = {1,7,9,2,5};
        int lower = 11;
        int upper = 11;
        FairPairs_2563 sol = new FairPairs_2563();
        System.out.println(sol.countFairPairs(nums, lower, upper));
    }
}
