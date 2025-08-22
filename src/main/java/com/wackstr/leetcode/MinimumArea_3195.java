package com.wackstr.leetcode;

/*
2025-08-22
 */
public class MinimumArea_3195 {
    public int minimumArea(int[][] grid){
        int minX = grid.length + 1;
        int minY = grid[0].length + 1;
        int maxX = -1;
        int maxY = -1;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    minX = Math.min(i, minX);
                    minY = Math.min(j, minY);
                    maxX = Math.max(i, maxX);
                    maxY = Math.max(j, maxY);
                }
            }
        }
        return (maxX - minX + 1) * (maxY - minY + 1);
    }

    public static void main(String[] args) {
        int[][] grid = {{0,1,0}, {1,0,1}};
        MinimumArea_3195 sol = new MinimumArea_3195();
        System.out.println(sol.minimumArea(grid));
    }
}
