package com.wackstr.leetcode;

/*
2025-12-05 3432
 */
public class Partitions_3432 {
    public int countPartitions(int[] nums){
        int cnt = 0;
        int sum = 0;
        for (int num : nums) sum += num;
        for (int i = 0; i < nums.length - 1; i++) {
            sum -= nums[i] * 2;
            if(sum % 2 == 0) cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] nums = {2,4,6,8};
        Partitions_3432 sol = new Partitions_3432();
        System.out.println(sol.countPartitions(nums));
    }
}
