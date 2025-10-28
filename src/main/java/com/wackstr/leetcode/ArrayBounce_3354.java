package com.wackstr.leetcode;

/*
2025-10-28
 */
public class ArrayBounce_3354 {
    public int countValidSelections(int[] nums) {

        int count = 0, len = nums.length;
        int sum = 0;
        for (int num : nums) sum += num;

        int halfSum = 0;

        for (int i = 0; i < len; i++) {
            halfSum += nums[i];
            if (nums[i] == 0) {

                if (2 * halfSum == sum) {
                    count += 2;
                } else if (Math.abs(sum - 2*halfSum) == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,4,0,4,1,0};
        ArrayBounce_3354 sol = new ArrayBounce_3354();
        System.out.println(sol.countValidSelections(nums));
    }
}
