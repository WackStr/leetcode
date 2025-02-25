package com.wackstr.leetcode;

/*
2025-02-02
 */
public class OddSumSubArrays_1524 {

    private static final int MODULUS = 1000000007;

    public int numOfSubarrays(int[] arr) {
        final int MOD = 1_000_000_007;
        int count = 0, prefixSum = 0;
        // evenCount starts as one since the initial sum (0) is even
        int oddCount = 0, evenCount = 1;

        for (int num : arr) {
            prefixSum += num;
            // If current prefix sum is even, add the number of odd subarrays
            if (prefixSum % 2 == 0) {
                count += oddCount;
                evenCount++;
            } else {
                // If current prefix sum is odd, add the number of even
                // subarrays
                count += evenCount;
                oddCount++;
            }

            count %= MOD; // To handle large results
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5};
        OddSumSubArrays_1524 sol = new OddSumSubArrays_1524();
        System.out.println(sol.numOfSubarrays(nums));
    }
}
