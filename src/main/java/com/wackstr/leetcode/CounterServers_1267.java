package com.wackstr.leetcode;

import java.util.HashSet;
import java.util.Set;

/*
2025-01-23
 */
public class CounterServers_1267 {
    public int countServers(int[][] grid){
        int m = grid.length, n = grid[0].length, servers = 0;
        int[] colCount = new int[n], rowCount = new int[m];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }

        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 1 && (rowCount[i] > 1 || colCount[j] > 1))
                    servers++;

            }
        }

        return servers;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,0}, {1,1}};
        CounterServers_1267 sol = new CounterServers_1267();
        System.out.println(sol.countServers(grid));
    }
}
