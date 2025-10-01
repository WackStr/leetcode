package com.wackstr.leetcode;

/*
2025-10-01
 */
public class BottleExchange_1518 {
    public int numWaterBottles(int numBottles, int numExchange){
        int total = numBottles;
        int free = numBottles;
        int nextBottles;
        while(free >= numExchange){
            nextBottles = free/numExchange;
            total += nextBottles;
            free = nextBottles + (free % numExchange);
        }
        return total;
    }

    public static void main(String[] args) {
        int numBottles = 9, numExchange = 3;
        BottleExchange_1518 sol = new BottleExchange_1518();
        System.out.println(sol.numWaterBottles(numBottles, numExchange));
    }
}
