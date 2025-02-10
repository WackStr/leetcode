package com.wackstr.leetcode;

import java.util.Arrays;

public class BestSightSeeingPair_1014 {
    public int maxScoreSightseeingPair(int[] values) {
        int[] lastBestPair = new int[values.length];
        lastBestPair[1] = 0;
        int max = getVal(values, 0, 1);
        for(int i = 2; i < values.length; i++) {
            int lastBestVal = getVal(values, lastBestPair[i - 1], i);
            int currVal = getVal(values, i-1, i);
            max = Math.max(max, Math.max(lastBestVal, currVal));
            lastBestPair[i] = lastBestVal > currVal ? lastBestPair[i-1] : i-1;
        }
        return max;
    }

    private int getVal(int[] values, int i, int j) {
        return values[i] + values[j] + i - j;
    }

    private static int maxScoreSightseeingPari_brute(int[] values) {
        int maxValue = Integer.MIN_VALUE;
        for(int i = 0; i < values.length; i++){
            for(int j = i+1; j < values.length; j++){
                int currValue = values[i] + values[j] + i - j;
                maxValue = Math.max(maxValue, currValue);
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        int[] values = {8,1,5,2,6};
        BestSightSeeingPair_1014 sol = new BestSightSeeingPair_1014();
        System.out.println(sol.maxScoreSightseeingPair(values));
    }
}
