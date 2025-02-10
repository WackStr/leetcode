package com.wackstr.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;

/*
2024-12-18
 */
public class FinalPrices_1475 {
    public int[] finalPrices(int[] prices){
        ArrayDeque<Integer> monotonicStack = new ArrayDeque<>();
        int[] finalPrices = new int[prices.length];
        for(int i = 0; i < prices.length; i++){
            while(!monotonicStack.isEmpty() && prices[monotonicStack.peek()] >= prices[i]){
                int oldIndex = monotonicStack.poll();
                finalPrices[oldIndex] = prices[oldIndex] - prices[i];
            }
            monotonicStack.push(i);
        }
        while(!monotonicStack.isEmpty()) {
            int index = monotonicStack.poll();
            finalPrices[index] = prices[index];
        }
        return finalPrices;
    }



    private static int[] finalPrices_bruteforce(int[] prices) {
        int[] finalPrices = new int[prices.length];
        for(int i = 0; i < prices.length; i++){
            int currPrice = prices[i];
            int discount = 0;
            for(int j = i+1; j < prices.length; j++){
                int price = prices[j];
                if(price <= currPrice){
                    discount = price;
                    break;
                }
            }
            finalPrices[i] = currPrice - discount;
        }
        return finalPrices;
    }

    public static void main(String[] args) {
        int[] prices = {8,7,4,2,8,1,7,7,10,1};
        FinalPrices_1475 sol = new FinalPrices_1475();
        System.out.println(Arrays.toString(sol.finalPrices(prices)));
    }
}
