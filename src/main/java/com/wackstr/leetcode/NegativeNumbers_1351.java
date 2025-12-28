package com.wackstr.leetcode;

import java.util.Arrays;

/*
2025-12-28 1351
 */
public class NegativeNumbers_1351 {
    public int countNegatives(int[][] grid){
        int cnt = 0;
        int n = grid[0].length;
        for (int[] row : grid) {
            for (int i = 0; i < row.length; i++) {
                if(row[i] < 0) {
                    cnt += (n - i);
                    break;
                }
            }
        }
        return cnt;
    }
}
