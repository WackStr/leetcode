package com.wackstr.leetcode;

/*
2025-12-15 2110
 */
public class SmoothStockPriceDescent_2110 {
    public long getDescentPeriods(int[] prices){
        int currSpan = 1;
        long total = currSpan;
        for (int i = 1; i < prices.length; i++) {
            currSpan = (prices[i] == prices[i - 1] - 1) ? currSpan + 1 : 1;
            total += currSpan;
        }
        return total;
    }

    public static void main(String[] args) {
        int[] prices = {1};
        SmoothStockPriceDescent_2110 sol = new SmoothStockPriceDescent_2110();
        System.out.println(sol.getDescentPeriods(prices));
    }
}
