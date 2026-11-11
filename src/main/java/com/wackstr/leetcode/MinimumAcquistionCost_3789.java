package com.wackstr.leetcode;

/*
2026-11-11 3789
 */
public class MinimumAcquistionCost_3789 {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        double splitCost = costBoth / 2.0;
        long res = 0;
        if (splitCost >= Math.max(cost1, cost2)) {
            res =  (long) need1 * cost1 + (long) need2 * cost2;
        } else{
            int commonCost = Math.min(cost1 + cost2, costBoth);
            res = (long) Math.min(need1, need2) * commonCost;
            res +=  need1 > need2 ? (long) (need1 - need2) * Math.min(costBoth, cost1) :
                    (long)(need2 - need1) * Math.min(cost2, costBoth);
        }
        return res;
    }

    public static void main(String[] args) {
        int cost1 = 12;
        int cost2 = 28;
        int costBoth = 50;
        int need1 = 6;
        int need2 = 8;
        MinimumAcquistionCost_3789 sol = new MinimumAcquistionCost_3789();
        System.out.println(sol.minimumCost(cost1, cost2, costBoth, need1, need2));

    }
}
