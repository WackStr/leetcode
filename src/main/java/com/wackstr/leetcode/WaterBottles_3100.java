package com.wackstr.leetcode;

/*
2025-10-02
 */
public class WaterBottles_3100 {
    public int maxBottlesDrunk(int numBottles, int numExchange){
        int total = numBottles;
        int free = numBottles;
        while(free >= numExchange){
            total += 1;
            free -= numExchange;
            numExchange += 1;
            free += 1;
        }
        return total;
    }

    public static void main(String[] args) {
        int numBottles = 13, numExchange = 6;
        WaterBottles_3100 sol = new WaterBottles_3100();
        System.out.println(sol.maxBottlesDrunk(numBottles, numExchange));
    }
}
