package com.wackstr.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
2025-07-06
 */
public class FindSumPairs_1865 {
    private int[] nums1;
    private int[] nums2;
    private Map<Integer, Integer> cnt;

    public FindSumPairs_1865(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.cnt = new HashMap<>();
        for (int num : nums2) {
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }
    }

    public void add(int index, int val) {
        int oldVal = nums2[index];
        cnt.put(oldVal, cnt.get(oldVal) - 1);
        nums2[index] += val;
        cnt.put(nums2[index], cnt.getOrDefault(nums2[index], 0) + 1);
    }

    public int count(int tot) {
        int ans = 0;
        for (int num : nums1) {
            int rest = tot - num;
            ans += cnt.getOrDefault(rest, 0);
        }
        return ans;
    }

    public static void main(String[] args) {
        FindSumPairs_1865 sol = new FindSumPairs_1865(
                new int[]{1,1,2,2,2,3},
                new int[]{1,4,5,2,5,4}
        );

        System.out.println(sol.count(7));
        sol.add(3, 2);
        System.out.println(sol.count(8));
        System.out.println(sol.count(4));
        sol.add(0,1);
        sol.add(1,1);
        System.out.println(sol.count(7));

    }
}
