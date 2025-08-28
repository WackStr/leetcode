package com.wackstr.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
2025-08-28
 */
public class MatrixDiagonalSort_3446 {
    public int[][] sortMatrix(int[][] grid){
        PriorityQueue<Integer> desc = new PriorityQueue<>();
        PriorityQueue<Integer> asc = new PriorityQueue<>((a,b) -> b - a);
        int n = grid.length;
        for(int i = n - 1; i > 0; i--){
            desc.clear();
            asc.clear();
            int row = i;
            for(int j = 0; j < n-i; j++){
                // put (i, j) in desc
                asc.offer(grid[row][j]);
                // put (j, i) in asc
                desc.offer(grid[j][row]);
                row++;
            }

            row = i;
            for(int j = 0; j < n-i; j++){
                // put desc (i, j)
                grid[row][j] = asc.poll();
                // put asc in (j, i)
                grid[j][row] = desc.poll();
                row++;
            }
        }

        for(int i = 0; i < n; i++){
            // put (i, i) in desc
            asc.offer(grid[i][i]);
        }

        for(int i = 0; i < n; i++){
            // put desc in (i, i)
            grid[i][i] = asc.poll();
        }

        return grid;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,7,3},{9,8,2},{4,5,6}};
        MatrixDiagonalSort_3446 sol = new MatrixDiagonalSort_3446();
        System.out.println(Arrays.deepToString(sol.sortMatrix(grid)));
    }
}
