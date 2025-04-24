package com.wackstr.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CompleteSubArrays_2799 {
    public int countCompleteSubarrays(int[] nums) {
        int totalDistinct = getTotalDistinct(nums);

        int totalSubarrays = 0;
        int left = 0;
        int right = 0;
        Map<Integer, Integer> currLookup = new HashMap<>();
        while(right < nums.length){

            while(right < nums.length && currLookup.size() < totalDistinct){
                currLookup.merge(nums[right], 1, Integer::sum);
                right++;
            }
            while(left < nums.length && currLookup.size() == totalDistinct) {
                totalSubarrays += nums.length - right + 1;
                currLookup.compute(nums[left], (k, v) -> v == 1 ? null : v - 1);
                left++;
            }
        }
        return totalSubarrays;
    }

    private static int getTotalDistinct(int[] nums) {
        Set<Integer> cnt = new HashSet<>();
        for(int num : nums){
            cnt.add(num);
        }
        return cnt.size();
    }

    public static void main(String[] args) {
        int[] nums = {459,459,962,1579,1435,756,1872,1597};
        CompleteSubArrays_2799 sol = new CompleteSubArrays_2799();
        System.out.println(sol.countCompleteSubarrays(nums));
    }
}
