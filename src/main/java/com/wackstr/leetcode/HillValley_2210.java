package com.wackstr.leetcode;

/*
2025-07-27
 */
public class HillValley_2210 {
    public int countHillValley(int[] nums){
        int cnt = 0;
        boolean prevDelta;
        int i = 1;

        while(i < nums.length && nums[i] == nums[0]) i++;

        if(i < nums.length) {
            prevDelta = nums[i] > nums[0];

            for(int j = i + 1; j < nums.length; j++) {
                int currDelta = nums[j] - nums[j - 1];
                if (currDelta != 0) {
                    cnt += ((currDelta > 0) ^ prevDelta) ? 1 : 0;
                    prevDelta = currDelta > 0;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] nums = {6,6,5,5,4,1};
        HillValley_2210 sol = new HillValley_2210();
        System.out.println(sol.countHillValley(nums));
    }
}
