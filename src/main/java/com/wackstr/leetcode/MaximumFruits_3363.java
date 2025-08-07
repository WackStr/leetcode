package com.wackstr.leetcode;

/*
2025-08-07
 */
public class MaximumFruits_3363 {

    private int[][] TOP_RIGHT = {{1, -1}, {1, 0}, {1, 1}};
    private int[][] BOTTOM_LEFT = {{-1, 1}, {0, 1}, {1, 1}};

    private int[] DIRECTIONS = {-1, 0, 1};

    public int maxCollectedFruits(int[][] fruits){

        int n = fruits.length;
        int[][] sol = new int[n][n];
        sol[n-1][n-1] = fruits[n-1][n-1];

        for(int i = n - 2; i >= 0; i--){
            int limit = Math.max(n - i - 2, i);
            int x = i + 1;
            for(int j = n - 1; j > limit; j--){
                int maxVal = 0;
                for(int dir : DIRECTIONS){
                    int y = j + dir;
                    if(x == n -1 && y == n-1 ||
                            (y < n && x < y))
                        maxVal = Math.max(maxVal, sol[x][y]);
                }
                sol[i][j] = fruits[i][j] + maxVal;
            }
        }

        for(int j = n-2; j >= 0; j--){
            int limit = Math.max(n - j - 2, j);
            int y = j + 1;
            for(int i = n -1; i > limit; i--){
                int maxVal = 0;
                for(int dir : DIRECTIONS){
                    int x = i + dir;
                    if(x == n - 1 && y == n - 1 || (x < n && y < x)){
                        maxVal = Math.max(maxVal, sol[x][y]);
                    }
                }
                sol[i][j] = fruits[i][j] +  maxVal;
            }
        }

        int diagonalSum = 0;
        for(int i = 0; i < n; i++){
            diagonalSum += fruits[i][i];
        }

        return sol[0][n-1] + sol[n-1][0] + diagonalSum
                - 2 * sol[n - 1][n - 1];
    }

    private int getMaxFruitsTR(
            int[][] fruits,
            int i,
            int j,
            int[][] dp) {
        if(dp[i][j] != -1) return dp[i][j];
        int maxVal = 0;
        for(int[] dir : TOP_RIGHT){
            int x = i + dir[0];
            int y = j + dir[1];
            if(y < fruits.length && x < y
            || (x == fruits.length - 1 && y == fruits.length - 1)){
                maxVal = Math.max(maxVal,
                        getMaxFruitsTR(fruits, x, y, dp));
            }
        }
        dp[i][j] = maxVal + fruits[i][j];
        return dp[i][j];
    }

    private int getMaxFruitsBL(
            int[][] fruits,
            int i,
            int j,
            int[][] dp) {
        if(dp[i][j] != -1) return dp[i][j];
        if(i == fruits.length - 1 && j == fruits.length - 1)
            return fruits[fruits.length -1][fruits.length - 1];
        int maxVal = 0;
        for(int[] dir : BOTTOM_LEFT){
            int x = i + dir[0];
            int y = j + dir[1];
            if(x < fruits.length && y < x
                    || (x == fruits.length - 1 && y == fruits.length - 1)){
                maxVal = Math.max(maxVal,
                        getMaxFruitsBL(fruits, x, y, dp));
            }
        }
        dp[i][j] =  maxVal + fruits[i][j];
        return dp[i][j];
    }

    public static void main(String[] args) {
        int[][] fruits = {{1,2,3,4},{5,6,8,7},{9,10,11,12},{13,14,15,16}};
        MaximumFruits_3363 sol = new MaximumFruits_3363();
        System.out.println(sol.maxCollectedFruits(fruits));
    }

}
