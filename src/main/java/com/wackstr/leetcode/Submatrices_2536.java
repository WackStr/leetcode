package com.wackstr.leetcode;

import java.util.Arrays;

/*
2025-11-14
 */
public class Submatrices_2536 {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] res = new int[n][n];
        for (var q : queries) {
            int r0 = q[0], c0 = q[1], r1 = q[2]+1, c1 = q[3]+1;
            res[r0][c0]++;
            if (c1 < n) res[r0][c1]--;
            if (r1 < n) {
                res[r1][c0]--;
                if (c1 < n) res[r1][c1]++;
            }
        }

        for (int i = 0; i < n; i++) for (int j = 1; j < n; j++)
            res[i][j] += res[i][j-1];

        for (int i = 1; i < n; i++) for (int j = 0; j < n; j++)
            res[i][j] += res[i-1][j];

        return res;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][]queries = new int[][]{{1,1,2,2}, {0,0,1,1}};
        Submatrices_2536 sol = new Submatrices_2536();
        System.out.println(Arrays.deepToString(sol.rangeAddQueries(n, queries)));
    }
}
