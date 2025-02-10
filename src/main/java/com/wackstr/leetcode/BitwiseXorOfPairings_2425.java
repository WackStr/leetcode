package com.wackstr.leetcode;

/*
2025-01-16
 */
public class BitwiseXorOfPairings_2425 {
    public int xorAllNums(int[] nums1, int[] nums2) {
        // Initialize XOR results for both arrays
        int xor1 = 0;
        int xor2 = 0;

        // Get lengths of both arrays
        int len1 = nums1.length;
        int len2 = nums2.length;

        // If nums2 length is odd, each element in nums1 appears odd times in final result
        if (len2 % 2 != 0) {
            for (int num : nums1) {
                xor1 ^= num;
            }
        }

        // If nums1 length is odd, each element in nums2 appears odd times in final result
        if (len1 % 2 != 0) {
            for (int num : nums2) {
                xor2 ^= num;
            }
        }

        // Return XOR of both results
        return xor1 ^ xor2;
    }

    private static int bruteForce(int[] nums1, int[] nums2) {
        int sum = 0;
        for(int n1 : nums1){
            for(int n2 : nums2) {
                sum ^= n1 ^ n2;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        BitwiseXorOfPairings_2425 sol = new BitwiseXorOfPairings_2425();
        System.out.println(sol.xorAllNums(nums1, nums2));
    }
}
