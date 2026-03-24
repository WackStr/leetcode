package com.wackstr.leetcode;

import java.util.Arrays;

/*
2026-03-24 2906
 */
public class ProductMatrix_2906 {
    public int[][] constructProductMatrix(int[][] grid) {
        final int MOD = 12345;
        int n = grid.length;
        int m = grid[0].length;
        int[][] p = new int[n][m];

        long suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                p[i][j] = (int) suffix;
                suffix = (suffix * grid[i][j]) % MOD;
            }
        }

        long prefix = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                p[i][j] = (int) (((long) p[i][j] * prefix) % MOD);
                prefix = (prefix * grid[i][j]) % MOD;
            }
        }

        return p;
    }

    public static void main(String[] args) {
        int[][] grid = {{10,20},{18,16},{17,14},{16,9},{14,6},{16,5},{14,8},{20,13},{16,10},{14,17}};
        ProductMatrix_2906 sol = new ProductMatrix_2906();
        System.out.println(Arrays.deepToString(sol.constructProductMatrix(grid)));
    }
}
