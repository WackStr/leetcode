package com.wackstr.leetcode;

/*
2026-04-30 3742
 */
public class ScoreInGrid_3742 {
    public int maxPathScore(int[][] grid, int k){
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][k+1];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                for(int cost = 0; cost <= k; cost++){
                    dp[i][j][cost] = -1;
                }
            }
        }
        dp[0][0][grid[0][0] == 0 ? 0 : 1] = grid[0][0];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int currCost = grid[i][j] == 0 ? 0 : 1;
                if(i > 0) {
                    for(int cost = 0; cost <= k - currCost; cost++){
                        if(dp[i-1][j][cost] != -1) {
                            dp[i][j][cost + currCost] = dp[i - 1][j][cost] + grid[i][j];
                        }
                    }
                }
                if(j > 0){
                    for(int cost = 0; cost <= k - currCost; cost++){
                        if(dp[i][j-1][cost] != -1) {
                            dp[i][j][cost + currCost] = Math.max(dp[i][j][cost + currCost], dp[i][j - 1][cost] + grid[i][j]);
                        }
                    }
                }
            }
        }
        int res = -1;
        for(int i = 0; i <= k; i++){
            res = Math.max(res, dp[m-1][n-1][i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 1},{1, 2}};
        int k = 1;
        ScoreInGrid_3742 sol = new ScoreInGrid_3742();
        System.out.println(sol.maxPathScore(grid, k));
    }
}
