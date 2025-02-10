package com.wackstr.leetcode;

/*
2024-12-7
 */
public class MinimumBallsInBag_1760 {
    public int minimumSize(int[] nums, int maxOperations) {
        // Binary search bounds
        int left = 1;
        int right = 0;

        for (int num : nums) {
            right = Math.max(right, num);
        }

        // Perform binary search to find the optimal maxBallsInBag
        while (left < right) {
            int middle = (left + right) / 2;

            // Check if a valid distribution is possible with the current middle value
            if (isPossible(middle, nums, maxOperations)) {
                right = middle; // If possible, try a smaller value (shift right to middle)
            } else {
                left = middle + 1; // If not possible, try a larger value (shift left to middle + 1)
            }
        }

        // Return the smallest possible value for maxBallsInBag
        return left;
    }

    // Helper function to check if a distribution is possible for a given maxBallsInBag
    private boolean isPossible(
            int maxBallsInBag,
            int[] nums,
            int maxOperations
    ) {
        int totalOperations = 0;

        // Iterate through each bag in the array
        for (int num : nums) {
            // Calculate the number of operations needed to split this bag
            int operations = (int) Math.ceil(num / (double) maxBallsInBag) - 1;
            totalOperations += operations;

            // If total operations exceed maxOperations, return false
            if (totalOperations > maxOperations) {
                return false;
            }
        }

        // We can split the balls within the allowed operations, return true
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {431,922,158,60,192,14,788,146,788,775,772,792,68,143,376,375,877,516,595,82,56,704,160,403,713,504,67,332,26};
        int maxOperations = 80;
        MinimumBallsInBag_1760 sol = new MinimumBallsInBag_1760();
        System.out.println(sol.minimumSize(nums, maxOperations));
    }
}
