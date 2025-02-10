package com.wackstr.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumCoins {
    public int minimumCoins(int[] coins, int targetSum){
        Map<Integer, Integer> dp = new HashMap<>();
        return solve(coins, targetSum, dp);
    }

    private int solve(int[] coins, int targetSum, Map<Integer, Integer> dp) {
        if(dp.containsKey(targetSum)) return dp.get(targetSum);
        if(targetSum == 0) return 0;
        int currVal = Integer.MAX_VALUE;
        for(int coin : coins){
            if(coin <= targetSum) {
                int val = 1 + solve(coins, targetSum - coin, dp);
                currVal = Math.min(val, currVal);
            }
        }
        dp.put(targetSum, currVal);
        return currVal;
    }

    public int minimumCoinsGreedy(int[] coins, int targetSum){
        Arrays.sort(coins);
        int count = 0;
        int currSum = targetSum;
        int i = coins.length - 1;
        while(i >= 0){
            int currVal = coins[i];
            while(currVal <= currSum){
                currSum -= currVal;
                count++;
            }
            if(currSum == 0) break;
            i--;
        }
        return currSum == 0 ? count : -1;
    }

    public static void main(String[] args) {
        int[] coins = {1, 4, 5};
        int targetSum = 13;
        MinimumCoins sol = new MinimumCoins();
        System.out.println(sol.minimumCoinsGreedy(coins, targetSum));
        System.out.println(sol.minimumCoins(coins, targetSum));
    }
}
