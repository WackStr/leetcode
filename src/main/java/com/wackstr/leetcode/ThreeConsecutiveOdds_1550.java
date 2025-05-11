package com.wackstr.leetcode;

/*
2025-05-11
 */
public class ThreeConsecutiveOdds_1550 {
    public boolean threeConsecutiveOdds(int[] nums){
        if(nums.length < 3) return false;
        int left = 0;
        int right = left;
        while(right < nums.length){
            if(nums[right] % 2 == 1) {
                if(right - left == 2) return true;
            }
            else left = right + 1;
            right++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,1};
        ThreeConsecutiveOdds_1550 sol = new ThreeConsecutiveOdds_1550();
        System.out.println(sol.threeConsecutiveOdds(nums));
    }
}
