package com.wackstr.leetcode;

import java.util.Arrays;
import java.util.List;

/*
2026-10-15 2913
 */
public class DistinctSubArrays_2913 {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        int answer = 0;

        for (int i = 0; i < n; i++) {
            boolean[] seen = new boolean[101];
            int distinct = 0;

            for (int j = i; j < n; j++) {
                int num = nums.get(j);

                if (!seen[num]) {
                    seen[num] = true;
                    distinct++;
                }

                answer += distinct * distinct;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1,2,1);
        DistinctSubArrays_2913 sol = new DistinctSubArrays_2913();
        System.out.println(sol.sumCounts(nums));

    }
}
