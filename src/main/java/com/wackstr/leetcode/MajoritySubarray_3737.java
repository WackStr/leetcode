package com.wackstr.leetcode;

/*
2026-06-25 3737
 */
public class MajoritySubarray_3737 {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int cnt = 0;
            for (int j = i; j < n; ++j) {
                cnt += (nums[j] == target ? 1 : -1);
                if (cnt > 0) {
                    ++ans;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,3};
        int target = 2;
        MajoritySubarray_3737 sol = new MajoritySubarray_3737();
        System.out.println(sol.countMajoritySubarrays(nums, target));
    }
}
