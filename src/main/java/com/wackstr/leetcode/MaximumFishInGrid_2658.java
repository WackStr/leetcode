package com.wackstr.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/*
2025-01-28
 */
public class MaximumFishInGrid_2658 {
    private static final int[][] deltas = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public int findMaxFish(int[][] grid){
        int[][] visited = new int[grid.length][grid[0].length];
        int max = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++) {
                if(visited[i][j] == 0 && grid[i][j] > 0){
                    max = Math.max(max, bfs(i, j, grid, visited));
                }
            }
        }
        return max;
    }

    private int bfs(int i, int j, int[][] grid, int[][] visited) {
        int total = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{i, j});
        while(!queue.isEmpty()){
            int n = queue.size();
            for(int k = 0; k < n; k++){
                int[] cell = queue.poll();
                if(visited[cell[0]][cell[1]] == 0) {
                    visited[cell[0]][cell[1]] = 1;
                    total += grid[cell[0]][cell[1]];
                    for (int[] delta : deltas) {
                        int[] newCell = {cell[0] + delta[0], cell[1] + delta[1]};
                        if (isValidCell(newCell, grid) && visited[newCell[0]][newCell[1]] == 0 && grid[newCell[0]][newCell[1]] > 0) {
                            queue.add(newCell);
                        }
                    }
                }
            }
        }
        return total;
    }

    private boolean isValidCell(int[] newCell, int[][] grid) {
        return newCell[1] >= 0 && newCell[1] < grid[0].length &&
                newCell[0] >= 0 && newCell[0] < grid.length;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,2,1,0}, {4,0,0,3}, {1,0,0,4}, {0,3,2,0}};
        grid = new int[][]{{4,0}};
        MaximumFishInGrid_2658 sol = new MaximumFishInGrid_2658();
        System.out.println(sol.findMaxFish(grid));
    }
}
