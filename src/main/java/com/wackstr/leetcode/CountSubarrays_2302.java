package com.wackstr.leetcode;

/*
2025-04-28
 */
public class CountSubarrays_2302 {
    public long countSubarrays(int[] nums, long k){
        long res = 0;
        long sum = 0;
        for(int left = 0, right = 0; right < nums.length; right++){
            sum += nums[right];
            while(left <= right && (right - left + 1) * sum >= k) {
                sum -= nums[left];
                left++;
            }
            res += right - left + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 4, 3, 5};
        int k = 10;
        CountSubarrays_2302 sol = new CountSubarrays_2302();
        System.out.println(sol.countSubarrays(nums, k));
    }
}
