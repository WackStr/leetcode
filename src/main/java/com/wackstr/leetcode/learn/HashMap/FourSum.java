package com.wackstr.leetcode.learn.HashMap;

import java.util.HashMap;
import java.util.Map;

public class FourSum {
    /*
    Given four integer arrays nums1, nums2, nums3, and nums4 all of length n,
    return the number of tuples (i, j, k, l) such that:

0 <= i, j, k, l < n
nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
     */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4){
        Map<Integer,Integer> abCount = new HashMap<>();
        for (int a : nums1) {
            for (int b : nums2) {
                int sum = a + b;
                abCount.merge(sum, 1, Integer::sum);
            }
        }

        int count = 0;
        for (int c : nums3) {
            for (int d : nums4) {
                count += abCount.getOrDefault(-(c + d), 0);
            }
        }

        return count;
    }
}
