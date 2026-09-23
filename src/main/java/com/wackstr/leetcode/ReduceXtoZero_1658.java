package com.wackstr.leetcode;

/*
2026-09-23 1658
 */
public class ReduceXtoZero_1658 {
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        int target = 0;
        int left = 0;
        int currSum = 0;
        int res = -1;

        for (int num : nums) {
            sum += num;
        }

        if(sum == x) return nums.length;

        target = sum - x;
        for(int right = 0; right < nums.length; right++){
            currSum += nums[right];
            while(currSum > target && left < right){
                currSum -= nums[left];
                left++;
            }
            if(currSum == target){
                res = Math.max(right - left + 1, res);
            }
        }
        if(res == -1) return -1;
        return nums.length - res;
    }

    public static void main(String[] args) {
        int[] nums = {8828,9581,49,9818,9974,9869,9991,10000,10000,10000,9999,9993,9904,8819,1231,6309};
        int x = 134365;
        ReduceXtoZero_1658 sol = new ReduceXtoZero_1658();
        System.out.println(sol.minOperations(nums, x));
    }
}
