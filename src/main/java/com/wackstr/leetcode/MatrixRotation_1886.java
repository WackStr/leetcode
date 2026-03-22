package com.wackstr.leetcode;

import java.util.Arrays;

/*
2026-03-22 1886
 */
public class MatrixRotation_1886 {
    public boolean findRotation(int[][] mat, int[][] target){
        if(isEqual(mat, target)) return true;
        for(int i = 0; i < 3; i++){
            rotate(mat);
            if(isEqual(mat, target)) return true;
        }
        return false;
    }

    private void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            int l = 0, r = n - 1;
            while (l < r) {
                int temp = matrix[i][l];
                matrix[i][l] = matrix[i][r];
                matrix[i][r] = temp;
                l++;
                r--;
            }
        }
    }

    private boolean isEqual(int[][] mat, int[][] target) {
        for (int i = 0; i < mat.length; i++) {
            if(!Arrays.equals(mat[i], target[i])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] mat = {{1,1}, {0,1}};
        int[][] target = {{1,1}, {1,0}};
        MatrixRotation_1886 sol = new MatrixRotation_1886();
        System.out.println(sol.findRotation(mat,target));
    }
}
