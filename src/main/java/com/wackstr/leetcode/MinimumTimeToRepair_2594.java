package com.wackstr.leetcode;

import java.util.Arrays;

/*
2025-03-16
 */
public class MinimumTimeToRepair_2594 {
    public long repairCars(int[] ranks, int cars){
        int min = Integer.MAX_VALUE;
        for(int rank : ranks){
            min = Math.min(rank, min);
        }
        if(cars == 1) return min;

        long left = 0;
        long right = (long) min * cars * cars;
        while(left < right){
            long mid = (right + left) / 2;
            if(isUpperBound(mid, ranks, cars)) {
                right = mid;
            }else{
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean isUpperBound(long mid, int[] ranks, int cars) {
        long currCars = 0;
        for(int rank : ranks){
            currCars += (long) Math.sqrt((double) mid / rank);
        }
        return currCars >= cars;
    }

    public static void main(String[] args) {
        int totalRanks = 100000;
        int[] ranks = new int[totalRanks];
        Arrays.fill(ranks, 1);
        int cars = 1000000;
        MinimumTimeToRepair_2594 sol = new MinimumTimeToRepair_2594();
        System.out.println(sol.repairCars(ranks, cars));
    }
}
