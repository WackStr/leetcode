package com.wackstr.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
2026-07-20 1260
 */
public class Shift2DGrid_1260 {
    public List<List<Integer>> shiftGrid(int[][] grid, int k){
        int m = grid.length;
        int n = grid[0].length;
        int total = m * n;
        int delta = k % total;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < grid[i].length; j++) {
                int coord = i * n + j;
                int shifted = (coord - delta + total) % total;
                int x = shifted / n;
                int y = shifted % n;
                row.add(grid[x][y]);
            }
            res.add(row);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,2,3},{4,5,6},{7,8,9}};
        int k = 1;
        Shift2DGrid_1260 sol = new Shift2DGrid_1260();
        System.out.println(sol.shiftGrid(grid, k));
    }
}
