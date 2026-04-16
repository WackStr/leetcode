package com.wackstr.leetcode;

import java.util.*;

/*
2026-04-16 3488
 */
public class ClosestEqualElement_3488 {
    public List<Integer> solveQueries(int[] nums, int[] queries) {

        Map<Integer, TreeSet<Integer>> map = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++)
            map.computeIfAbsent(nums[i], k -> new TreeSet<>()).add(i);

        List<Integer> res = new ArrayList<>();

        for (int query : queries) {
            int num = nums[query];
            TreeSet<Integer> set = map.get(num);
            if(set.size() == 1) res.add(-1);
            else {
                Integer lower = set.floor(query - 1);
                Integer upper = set.ceiling(query + 1);

                int ans;
                ans = lower == null ? query + n - set.last() : query - lower;

                if (upper == null) {
                    ans = Math.min(ans, (n - query + set.first()));
                } else {
                    ans = Math.min(ans, upper - query);
                }

                res.add(ans);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] queries = {0,1,2,3};
        ClosestEqualElement_3488 sol = new ClosestEqualElement_3488();
        System.out.println(sol.solveQueries(nums, queries));
    }
}
