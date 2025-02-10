package com.wackstr.leetcode;

import java.util.*;

/*
2024-11-19
 */
public class MaximumDistinctSubArraySum_2461 {

    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0;
        long currSum = 0;
        Map<Integer, Integer> currSet = new HashMap<>();
        int left = 0;
        int right = 0;

        while(right < nums.length) {
            // if there is a complete window remove the last item and slide
            if(right - left == k){
                currSet.remove(nums[left]);
                currSum -= nums[left];
                left++;
            }
            // if right is repeated -> move up the left index
            if (currSet.containsKey(nums[right])) {
                int newIndex = currSet.get(nums[right]);
                for(int i = left; i <= newIndex; i++){
                    currSum -= nums[i];
                    currSet.remove(nums[i]);
                }
                left = newIndex + 1;
            }
            // add the latest item
            currSet.put(nums[right], right);
            currSum += nums[right];
            right++;

            if(right - left == k && currSet.size() == k && currSum > maxSum){
                    maxSum = currSum;
            }
        }

        return maxSum;
    }

    public long maximumSubArrayBetterVersion(int[] nums, int k){
        long maximumSum = 0;
        long currSum = 0;
        int left = 0;
        int right = 0;
        Map<Integer, Integer> numToIndex = new HashMap<>();

        while(right < nums.length){
            int currNum = nums[right];
            int lastOccurence = numToIndex.getOrDefault(currNum, -1);
            while(left <= lastOccurence || (right - left + 1) > k){
                left++;
            }
            currSum += currNum;
            numToIndex.put(currNum, right);
            if(right - left + 1 == k){
                maximumSum =  Math.max(currSum, maximumSum);
            }
            right++;
        }
        return maximumSum;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,1,3};
        int k = 2;
        MaximumDistinctSubArraySum_2461 sol = new MaximumDistinctSubArraySum_2461();
        System.out.println(sol.maximumSubarraySum(nums, k));
    }
}
