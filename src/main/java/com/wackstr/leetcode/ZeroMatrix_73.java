package com.wackstr.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
2025-05-21
 */
public class ZeroMatrix_73 {
    public void setZeroes(int[][] matrix){
        int n = matrix[0].length;
        int m = matrix.length;
        Set<Integer> rows = new HashSet<>();
        Set<Integer> columns = new HashSet<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0) {
                    rows.add(i);
                    columns.add(j);
                }
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(rows.contains(i) || columns.contains(j))
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
