package com.wackstr.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/*
2024-11-17
 */
public class ShortestSubArrayForSum_862 {
    public int shortestSubarray(int[] nums, int k) {
        long[] sumPrefix = new long[nums.length + 1];
        for(int i = 1; i <= nums.length; i++){
            sumPrefix[i] = nums[i - 1] + sumPrefix[i-1];
        }
        int shortestLength = nums.length + 1;
        Deque<Integer> monotonicSums = new ArrayDeque<>();
        for(int i = 0; i <= nums.length; i++){
            while(
                    !monotonicSums.isEmpty() &&
                    (sumPrefix[i] - sumPrefix[monotonicSums.peekFirst()]) >= k){
                shortestLength = Math.min(
                        shortestLength,
                        i - monotonicSums.pollFirst()
                );
            }

            while(
                    !monotonicSums.isEmpty() &&
                    sumPrefix[i] <= sumPrefix[monotonicSums.peekLast()]){
                monotonicSums.pollLast();
            }
            monotonicSums.offerLast(i);

        }
        if(shortestLength == nums.length + 1){
            return -1;
        }else{
            return shortestLength;
        }

    }

    private boolean subArraySumExists(int[] nums, int k, int subSize) {
        int currSum = sumArray(nums, 0, subSize);
        if(currSum == k) return true;
        for(int i = 1; i < nums.length - subSize + 1; i++){
            currSum = currSum - nums[i-1] + nums[i + subSize - 1];
            if(currSum == k) return true;
        }
        return false;
    }

    private int sumArray(int[] nums, int i, int subSize) {
        int ans = 0;
        for(int index = i; index < subSize; index++){
            ans += nums[index];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        int k = 1;
        ShortestSubArrayForSum_862 sol = new ShortestSubArrayForSum_862();
        System.out.println(sol.shortestSubarray(nums, k));
    }
}
