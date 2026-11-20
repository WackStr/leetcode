package com.wackstr.leetcode;

import java.util.Arrays;

/*
2026-11-20 3041
 */
public class ConsecutiveElements_3041 {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);
        int best = 1, keep = 1, bump = 1, last = -10;
        for (int x : nums) {
            switch (x - last) {
                case 0 -> bump = keep + 1;  // x repeat: bump it on top of keep
                case 1 -> { keep++; bump++; }  // x extends keep, x + 1 extends bump
                case 2 -> { keep = bump + 1; bump = 1; }  // x extends bump, x + 1 starts over
                default -> keep = bump = 1;
            }
            best = Math.max(best, Math.max(keep, bump));
            last = x;
        }
        return best;
    }

    public static void main(String[] args) {
        int[] nums = {4,12,8,14,14,12,11,20,17,17,4,10,10,18,1,16};
        ConsecutiveElements_3041 sol = new ConsecutiveElements_3041();
        System.out.println(sol.maxSelectedElements(nums));
    }
}
