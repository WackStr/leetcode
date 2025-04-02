package com.wackstr.leetcode;

public class MaximumTriplet_2873 {
    public long maximumTripletValue(int[] nums) {
        long res = 0, imax = 0, dmax = 0;
        for (int num : nums) {
            res = Math.max(res, dmax * num);
            dmax = Math.max(dmax, imax - num);
            imax = Math.max(imax, num);
        }
        return res;
    }

}
