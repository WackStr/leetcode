package com.wackstr.leetcode;

/*
2026-05-19 2540
 */
public class MinimumCommonValue_2540 {
    public int getCommon(int[] nums1, int[] nums2){
        int left = 0;
        int right = 0;
        while(left < nums1.length && right < nums2.length){
            if(nums1[left] == nums2[right]) return nums1[left];
            if(nums1[left] <  nums2[right]) left++;
            else right++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3};
        int[] nums2 = {2,4};
        MinimumCommonValue_2540 sol = new MinimumCommonValue_2540();
        System.out.println(sol.getCommon(nums1, nums2));
    }
}
