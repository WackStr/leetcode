package com.wackstr.leetcode;

/*
3011. 2024-11-06: Find if Array can be sorted
 */
public class SetBitSwapSortArray {

    public boolean canSortArray(int[] nums) {
        if (nums.length <= 1){
            return true;
        }else {

            int tracker = 0;
            int sortDirection = 0;
            int rollingMin = nums[0];
            int rollingMax = nums[0];
            int currSetBits = getSetBits(nums[0]);
            for (int i = 1; i < nums.length; i++) {
                int setBits = getSetBits(nums[i]);
                if (setBits == currSetBits) {
                    if (nums[i] < rollingMin) rollingMin = nums[i];
                    else if (nums[i] > rollingMax) rollingMax = nums[i];
                } else {
                    if (sortDirection == 0) {
                        sortDirection = nums[i] > tracker ? 1 : -1;
                    } else if (!isSorted(tracker, rollingMin, rollingMax, sortDirection)) {
                        return false;
                    }
                    tracker = selectTracker(sortDirection, rollingMin, rollingMax);
                    rollingMax = nums[i];
                    rollingMin = nums[i];
                    currSetBits = setBits;
                }
            }
            return isSorted(tracker, rollingMin, rollingMax, sortDirection);
        }
    }

    private int selectTracker(int sortDirection, int rollingMin, int rollingMax) {
        return sortDirection > 0 ? rollingMax : rollingMin;
    }

    private boolean isSorted(int tracker, int rollingMin, int rollingMax, int sortDirection) {
        if(sortDirection == 0){
            return true;
        }else if(sortDirection > 0){
            return rollingMin >= tracker && rollingMax >= tracker;
        }else{
            return rollingMin <= tracker && rollingMax <= tracker;
        }
    }

    private int getSetBits(int num) {
        int cnt = 0;
        int currNum = num;
        while(currNum > 0){
            cnt += currNum & 1;
            currNum = currNum >> 1;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] nums = {1,2};
        SetBitSwapSortArray sol = new SetBitSwapSortArray();
        System.out.println(sol.canSortArray(nums));
    }
}
