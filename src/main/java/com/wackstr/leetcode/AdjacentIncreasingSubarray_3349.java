package com.wackstr.leetcode;

import java.util.Arrays;
import java.util.List;

/*
2025-10-14
 */
public class AdjacentIncreasingSubarray_3349 {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k){
        int left = 0;
        int right = 1;
        while(left <= nums.size() - 2 * k){
            while(right < nums.size() && nums.get(right) > nums.get(right - 1)) {
                right++;
            }
            int delta = right - left;
            if(delta >= 2 * k) return true;
            if(delta >= k) {
                left = right;
                right++;
                while(right < nums.size() && nums.get(right) > nums.get(right - 1)) {
                    right++;
                }
                delta = right - left;
                if(delta >= k) return true;
            }
            left = right;
            right++;
        }
        return false;
    }


    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(19,4,19,6,18);
        int k = 2;
        AdjacentIncreasingSubarray_3349 sol = new AdjacentIncreasingSubarray_3349();
        System.out.println(sol.hasIncreasingSubarrays(nums, k));
    }
}
