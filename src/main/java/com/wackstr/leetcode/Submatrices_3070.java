package com.wackstr.leetcode;

/*
2026-03-18 3070
 */
public class Submatrices_3070 {
    public int countSubmatrices(int[][] grid, int k) {
        int m = grid[0].length;
        int[] cols = new int[m];
        int res = 0;

        for (int[] ints : grid) {
            int rows = 0;
            for (int j = 0; j < m; j++) {
                cols[j] += ints[j];
                rows += cols[j];
                if (rows <= k) {
                    res++;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{9,5}, {10,8},{7,6}};
        int k = 3;
        Submatrices_3070 sol = new Submatrices_3070();
        System.out.println(sol.countSubmatrices(grid, k));
    }
}
