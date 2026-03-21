package com.wackstr.leetcode;

import java.util.Arrays;

/*
2026-03-21 3643
 */
public class FlipMatrix_3643 {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int top = x;
        int bottom = x+k-1;
        while(top < bottom){
            for(int j=y;j<y+k;j++){
                int temp = grid[top][j];
                grid[top][j] = grid[bottom][j];
                grid[bottom][j] = temp;
            }
            top++;
            bottom--;
        }
        return grid;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int x = 1;
        int y = 0;
        int k = 3;
        FlipMatrix_3643 sol = new FlipMatrix_3643();
        System.out.println(Arrays.deepToString(sol.reverseSubmatrix(grid, x, y, k)));
    }
}
