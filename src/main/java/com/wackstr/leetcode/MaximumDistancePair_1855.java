package com.wackstr.leetcode;

import com.wackstr.leetcode.utility.IntArrayReader;

import java.io.IOException;

/*
2026-04-19 1855
 */
public class MaximumDistancePair_1855 {
    public int maxDistance(int[] nums1, int[] nums2){
        // not possible for nums1 <= nums2
        if(nums1[nums1.length - 1] > nums2[0]) return 0;
        int res = 0;
        int i = nums1.length - 1;
        int j = nums2.length - 1;
        while(j >= 0) {
            while (i >= 0 && nums1[i] <= nums2[j]) {
                res = Math.max(res, j - i);
                i--;
            }
            j--;
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        int[] nums1 = {55,30,5,4,2};
        int[] nums2 = {100,20,10,10,5};
        MaximumDistancePair_1855 sol = new MaximumDistancePair_1855();
        System.out.println(sol.maxDistance(nums1, nums2));
    }
}
