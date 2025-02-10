package com.wackstr.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinimumCostForTravel_983 {
    public int mincostTickets(int[] days, int[] costs){
        Map<Integer, Integer> dp = new HashMap<>();
        return solve(days, 0, costs, dp);
    }

    private int solve(int[] days, int i, int[] costs, Map<Integer, Integer> dp) {
        if(i >= days.length) return 0;
        int currDay = days[i];
        if(dp.containsKey(currDay)) return dp.get(currDay);


        int solution = Math.min(
                costs[0] + solve(days, findNextIndex(days, i, 1), costs, dp),
                Math.min(
                        costs[1] + solve(days, findNextIndex(days, i, 7), costs, dp),
                        costs[2] + solve(days, findNextIndex(days, i, 30), costs, dp)
                )
        );
        dp.put(currDay, solution);
        return solution;
    }

    private int findNextIndex(int[] days, int currIndex, int skipDays) {
        int finalIndex = currIndex;
        while(finalIndex < days.length && days[finalIndex] < days[currIndex] + skipDays){
            finalIndex++;
        }
        return finalIndex;
    }

    public static void main(String[] args) {
        int[] days = {1, 4, 6, 7, 8, 20};
        int[] costs = {2, 7, 15};
        MinimumCostForTravel_983 sol = new MinimumCostForTravel_983();
        System.out.println(sol.mincostTickets(days, costs));
    }
}
