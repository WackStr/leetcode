package com.wackstr.leetcode;


public class LargestBitwiseAndSubset {

    private static final int BIT_COUNT = 24;
    public int largestCombination(int[] candidates) {
        int runningMax = 0;
        for (int i = 0; i < BIT_COUNT; i++){
            int curMask = 1 << i;
            int currCount = 0;
            for(int num : candidates){
                if((num & curMask) == curMask){
                    currCount++;
                }
            }
            if(currCount > runningMax){
                runningMax = currCount;
            }

        }
        return runningMax;
    }

    public static void main(String[] args) {
        int[] in = {16,17,71,62,12,24,14};
        LargestBitwiseAndSubset sol = new LargestBitwiseAndSubset();
        System.out.println(sol.largestCombination(in));
    }
}
