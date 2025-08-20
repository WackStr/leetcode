package com.wackstr.leetcode;

/*
2025-08-20
 */
public class SubMatrix_1277 {
    public int countSquares(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length, result = 0, prev = 0;
        int[] dp = new int[col + 1];

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (matrix[i - 1][j - 1] == 1) {
                    int temp = dp[j];
                    dp[j] = 1 + Math.min(prev, Math.min(dp[j - 1], dp[j]));
                    prev = temp;
                    result += dp[j];
                } else {
                    dp[j] = 0;
                }
            }
        }
        return result;
    }

    private void mark(int[][] matrix, int i, int j, int delta) {
        for(int a = i; a < i + delta; a++){
            for(int b = j; b< j + delta; b++){
                matrix[a][b] = -1;
            }
        }
    }

    public static void main(String[] args) {

        int[][] matrix = {
            {0, 1, 1, 1},
            {1, 1, 1, 1},
            {0, 1, 1, 1}
        };

        SubMatrix_1277 sol = new SubMatrix_1277();
        System.out.println(sol.countSquares(matrix));

    }
}
