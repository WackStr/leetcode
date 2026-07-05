package com.wackstr.leetcode;

import java.util.Arrays;
import java.util.List;

/*
2026-07-05 1301
 */
public class MaxScorePaths_1301 {

    private static final int[][] DIRECTIONS = {{1,0},{0,1},{1,1}};
    private static final int MOD = 1_000_000_007;

    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        int[] res = new int[2];
        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            grid[i] = board.get(i).toCharArray();
        }

        res[0] = getMaxScore(grid);
        res[1] = getPathCount(res[0], grid);
        return res;
    }
    private static int getPathCount(int maxScore, char[][] grid){
        int n = grid.length;
        int[][][] dp = new int[n][n][maxScore+1];
        for(int i = n - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                if(grid[i][j] != 'X' && grid[i][j] != 'S') {
                    for (int[] dir : DIRECTIONS) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        int offset = 0;
                        if(maxScore > 0){
                            offset = grid[i][j] == 'E' ? 0 :  (grid[i][j] - '0');
                        }
                        if (x >= 0 && x < n && y >= 0 && y < n) {
                            if(grid[x][y] == 'S'){
                                dp[i][j][offset] = 1;
                            }else {
                                for (int k = offset; k <= maxScore; k++) {
                                    dp[i][j][k] = (dp[i][j][k]+dp[x][y][k - offset]) % MOD;
                                }
                            }
                        }
                    }

                }
            }
        }
        return dp[0][0][maxScore];
    }

    private static int getMaxScore(char[][] grid) {
        int n = grid.length;

        int[][] dp = new int[n][n];


        dp[n-1][n-1] = 0;
        for(int i = n-1; i>=0;i--){
            for(int j = n-1; j >= 0; j--){
                if(grid[i][j] != 'X' && grid[i][j] != 'E' && grid[i][j] != 'S') {
                    for (int[] dir : DIRECTIONS) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if (x >= 0 && x < n && y >= 0 && y < n && (dp[x][y] > 0 || grid[x][y] == 'S' )) {
                            dp[i][j] = Math.max(dp[i][j],dp[x][y] + (grid[i][j]-'0'));
                        }
                    }
                }
            }
        }
        return Math.max(dp[1][0], Math.max(dp[0][1], dp[1][1]));
    }

    public static void main(String[] args) {
        String[] board = {"E11","XXX","11S"};
        MaxScorePaths_1301 sol = new MaxScorePaths_1301();
        System.out.println(Arrays.toString(
                sol.pathsWithMaxScore(Arrays.asList(board))));
    }
}
