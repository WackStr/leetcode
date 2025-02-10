package com.wackstr.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/*
2025-01-22
 */
public class HighestPeak_1765 {
    public int[][] highestPeak(int[][] isWater){
        int[][] solution = new int[isWater.length][isWater[0].length];

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        int m = isWater.length;
        int n = isWater[0].length;
        ArrayDeque<int[]> cells = new ArrayDeque<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                solution[i][j] = -1;
                if(isWater[i][j] == 1){
                    cells.add(new int[]{i, j});
                }
            }
        }
        int heightOfNextLayer = 0;
        while(!cells.isEmpty()) {
            int cnt = cells.size();
            for (int i = 0; i < cnt; i++) {
                int[] cell = cells.pollLast();
                solution[cell[0]][cell[1]] = heightOfNextLayer;

                for (int k = 0; k < dx.length; k++) {
                    int[] nextCell = new int[]{cell[0] + dx[k], cell[1] + dy[k]};
                    if (
                            isValidCell(nextCell, m, n)
                                    &&
                                    solution[nextCell[0]][nextCell[1]] == -1) {
                        cells.addFirst(nextCell);
                    }
                }
            }
            heightOfNextLayer++;
        }
        return solution;
    }

    private boolean isValidCell(int[] cell, int m, int n) {
        return cell[0] >= 0 && cell[0] < m && cell[1] >= 0 && cell[1] < n;
    }

    public static void main(String[] args) {
        int[][] isWater = {{0, 0, 1}, {1, 0,0}, {0, 0, 0}};
        HighestPeak_1765 sol = new HighestPeak_1765();
        System.out.println(Arrays.deepToString(sol.highestPeak(isWater)));
    }
}
