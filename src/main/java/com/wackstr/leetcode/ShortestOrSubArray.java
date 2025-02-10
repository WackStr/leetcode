package com.wackstr.leetcode;

public class ShortestOrSubArray {
    public int minimumSubarrayLength(int[] nums, int k) {
        int runningMin = nums.length + 1;
        int startingIndex = 0;
        while(startingIndex < nums.length) {
            int endingIndex = findMinimumExpansion(nums, startingIndex, k);
            if (endingIndex == -1) {
                return runningMin == nums.length + 1 ? -1 : runningMin;
            } else if (endingIndex == startingIndex) {
                return 1;
            } else {

                startingIndex = shrinkStartingIndex(nums, startingIndex, endingIndex, k);
                int currLength = endingIndex - startingIndex + 1;
                if (currLength < runningMin) {
                    runningMin = currLength;
                }
                startingIndex++;
            }
        }
        return runningMin;
    }

    private int shrinkStartingIndex(int[] nums, int startingIndex, int endingIndex, int k) {
        int runningOr = nums[endingIndex];
        int i = endingIndex - 1;
        for(; i >= startingIndex; i--){
            if(runningOr >= k){
                break;
            }else{
                runningOr |= nums[i];
            }
        }
        return i + 1;
    }

    private int findMinimumExpansion(int[] nums, int startingIndex, int k) {
        int runningOr = nums[startingIndex];
        for(int i = startingIndex + 1; i < nums.length; i++){
            if(runningOr >= k){
                return i - 1;
            }else{
                runningOr |= nums[i];
            }
        }
        return runningOr >= k ? nums.length - 1 : -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,65,34,32,19,76};
        int k = 100;
        ShortestOrSubArray sol = new ShortestOrSubArray();
        System.out.println(sol.minimumSubarrayLength(nums, k));
    }
}
