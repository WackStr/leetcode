package com.wackstr.leetcode;

import java.util.Arrays;

/*
2026-05-04 48
 */
public class RotateImage_48 {
    public void rotate(int[][] matrix){
        int n = matrix.length;
        for(int i = 0; i < (n % 2  == 0 ? n/2 : n/2+1); i++){
            for(int j = 0; j < n/2;j++){
                // (i,j) -> (j,i) -> (j,n-i-1)
                // (j, n-i-1) -> (n-i-1, j) -> (n-i-1, n-j-1)
                // (n-i-1, n-j-1) -> (n-j-1, n-i-1) -> (n-j-1, i)
                // (i,j) => (j, n-i-1) => (n-i-1, n-j-1) => (n-j-1, i)
                int temp1 = matrix[j][n-i-1];
                int temp2 = matrix[n-i-1][n-j-1];
                int temp3 = matrix[n-j-1][i];
                matrix[j][n-i-1] = matrix[i][j];
                matrix[n-i-1][n-j-1] = temp1;
                matrix[n-j-1][i] = temp2;
                matrix[i][j] = temp3;
            }
        }
    }


    private static int[][] squareMatrix(int n){
        int[][] matrix = new int[n][n];
        for(int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                matrix[i][j] = i * n + j + 1;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = squareMatrix(1);
        System.out.println(Arrays.deepToString(matrix));
        RotateImage_48 sol = new RotateImage_48();
        sol.rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
