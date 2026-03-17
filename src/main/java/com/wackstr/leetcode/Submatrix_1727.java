package com.wackstr.leetcode;

import java.util.Arrays;

/*
2026-03-17 1727
 */
public class Submatrix_1727 {

    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int res = 0;
        for (int i = 1; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 1) matrix[i][j] = matrix[i - 1][j] + 1;
            }
        }

        for (int[] row : matrix) {
            Arrays.sort(row);
            for (int j = 1; j <= n; ++j) {
                res = Math.max(res, j * row[n - j]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{0,0,1},{1,1,1},{1,0,1}};
        Submatrix_1727 sol = new Submatrix_1727();
        System.out.println(sol.largestSubmatrix(matrix));
    }
}
