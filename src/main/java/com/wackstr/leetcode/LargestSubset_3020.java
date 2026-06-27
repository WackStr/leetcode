package com.wackstr.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
2026-06-27 3020
 */
public class LargestSubset_3020 {
    public int maximumLength(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int num : nums) {
            cnt.merge(num, 1, Integer::sum);
        }

        int oneCnt = cnt.getOrDefault(1, 0);
        // ans is at least the number of occurrences of 1, rounded down to an odd number
        int ans = (oneCnt & 1) == 1 ? oneCnt : oneCnt - 1;

        cnt.remove(1);

        for (int num : cnt.keySet()) {
            int res = 0;
            int x = num;

            while (cnt.containsKey(x) && cnt.get(x) > 1) {
                res += 2;
                x *= x;
            }

            ans = Math.max(ans, res + (cnt.containsKey(x) ? 1 : -1));
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {5,4,1,2,2};
        LargestSubset_3020 sol = new LargestSubset_3020();
        System.out.println(sol.maximumLength(nums));
    }
}
