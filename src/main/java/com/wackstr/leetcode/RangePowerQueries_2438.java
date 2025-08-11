package com.wackstr.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
2025-08-11
 */
public class RangePowerQueries_2438 {

    private static final int MOD = 1000000007;

    public int[] productQueries(int n, int[][] queries) {
        List<Integer> bins = new ArrayList<>();
        int rep = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                bins.add(rep);
            }
            n /= 2;
            rep *= 2;
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            long cur = 1;
            int start = queries[i][0];
            int end = queries[i][1];
            for (int j = start; j <= end; j++) {
                cur = (cur * bins.get(j)) % MOD;
            }
            ans[i] = (int) cur;
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 15;
        int[][] queries = {{0,1}, {2,2}, {0,3}};
        RangePowerQueries_2438 sol = new RangePowerQueries_2438();
        System.out.println(Arrays.toString(sol.productQueries(n, queries)));
    }
}
