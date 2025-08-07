package com.wackstr.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/*
2025-08-07
 */
public class MaximumFruits_3363 {

    private int[][] TOP_RIGHT = {{1, -1}, {1, 0}, {1, 1}};
    private int[][] BOTTOM_LEFT = {{-1, 1}, {0, 1}, {1, 1}};

    public int maxCollectedFruits(int[][] fruits){

        int n = fruits.length;
        int diagonalSum = 0;
        for(int i = 0; i < n; i++){
            diagonalSum += fruits[i][i];
        }

        int[][] dp = new int[n][n];
        for (int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        dp[n - 1][n-1] = fruits[n-1][n-1];
        int maxRight = getMaxFruitsTR(fruits, 0, n - 1, dp);
        int maxBottom = getMaxFruitsBL(fruits, n-1, 0, dp);

        return diagonalSum + maxRight + maxBottom
                - 2 * fruits[fruits.length - 1][fruits.length - 1];
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
