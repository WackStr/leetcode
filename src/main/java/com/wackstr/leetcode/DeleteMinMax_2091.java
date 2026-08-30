package com.wackstr.leetcode;

/*
2026-08-30 2091
 */
public class DeleteMinMax_2091 {
    public int minimumDeletions(int[] nums) {
        if(nums.length <= 2) return nums.length;
        if(nums.length == 3) return 2;
        int min = Integer.MAX_VALUE;
        int iMin = 0;
        int max = Integer.MIN_VALUE;
        int iMax = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] < min){
                min = nums[i];
                iMin = i;
            }
            if(nums[i] > max){
                max = nums[i];
                iMax = i;
            }
        }
        if(iMin > iMax) {
            int x = iMin;
            iMin = iMax;
            iMax = x;
        }
        return Math.min(
                Math.min(iMin+1 + nums.length - iMax, 1 + iMax ),
                nums.length- iMin);
    }

    public static void main(String[] args) {
        int[] nums = {2,10,7,5,4,1,8,6};
        DeleteMinMax_2091 sol = new DeleteMinMax_2091();
        System.out.println(sol.minimumDeletions(nums));
    }
}
