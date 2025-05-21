package com.wackstr.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
2025-05-21
 */
public class ZeroMatrix_73 {
    public void setZeroes(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[] rows = new boolean[n];
        boolean[] columns = new boolean[m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == 0) {
                    rows[i] = true;
                    columns[j] = true;
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(rows[i] || columns[j])
                    matrix[i][j] = 0;

            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,1,1}, {1, 0, 1}, {1,1,1}};
        ZeroMatrix_73 sol = new ZeroMatrix_73();
        sol.setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
