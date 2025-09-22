package com.wackstr.leetcode;

/*
2025-09-22
 */
public class MaxiumFrequencyElement_3005 {
    public int maxFrequencyElements(int[] nums) {
        int[] arr = new int[101];
        int maxFreq = 0;
        int res = 0;
        for(int num : nums) arr[num]++;
        for(int num : arr) maxFreq = Math.max(maxFreq, num);
        for(int num : arr) if(num == maxFreq) res += maxFreq;
        return res;
    }
}
