package com.wackstr.leetcode;

/*
2026-06-21 1833
 */
public class MaximumIceCreamBars_1833 {
    public int maxIceCream(int[] costs, int coins) {
        int maxCost = 0;
        int minCost = Integer.MAX_VALUE;
        for (int cost : costs) {
            maxCost = Math.max(cost, maxCost);
            minCost = Math.min(cost, minCost);
        }
        int[] cnt = new int[maxCost + 1];
        for (int cost : costs) {
            cnt[cost]++;
        }
        int res = 0;
        for(int cost = minCost; cost <= maxCost && cost <= coins; cost++){
            if(cnt[cost] == 0) continue;
            int buy = Math.min(coins/cost, cnt[cost]);
            res += buy;
            coins -= buy * cost;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] costs = {1,6,3,1,2,5};
        int coins = 20;
        MaximumIceCreamBars_1833 sol = new MaximumIceCreamBars_1833();
        System.out.println(sol.maxIceCream(costs, coins));
    }
}
