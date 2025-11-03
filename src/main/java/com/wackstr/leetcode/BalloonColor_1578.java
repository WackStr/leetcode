package com.wackstr.leetcode;

/*
2025-11-03
 */
public class BalloonColor_1578 {
    public int minCost(String color, int[] neededTime){
        int time = 0;
        char curr = color.charAt(0);
        int currMax = neededTime[0];
        int currSum = neededTime[0];
        boolean duplicate = false;
        for(int i = 1; i < color.length(); i++){
            if(color.charAt(i) == curr){
                currSum += neededTime[i];
                currMax = Math.max(currMax, neededTime[i]);
                duplicate = true;
            }else{
                if(duplicate){
                    time += currSum - currMax;
                }
                curr = color.charAt(i);
                currMax = neededTime[i];
                currSum = currMax;
                duplicate = false;
            }
        }
        if(duplicate) time += currSum - currMax;
        return time;
    }
}
