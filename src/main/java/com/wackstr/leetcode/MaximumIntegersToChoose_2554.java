package com.wackstr.leetcode;

import java.util.HashSet;
import java.util.Set;

/*
2024-12-6
 */
public class MaximumIntegersToChoose_2554{
    public int maxCount(int[] banned, int n, int maxSum){
        Set<Integer> bannedSet = new HashSet<>();
        int count = 0;
        int runningSum = 0;

        for(int bannedNum : banned){
            bannedSet.add(bannedNum);
        }

        for(int i = 1; i <= n; i++){
            if(!bannedSet.contains(i)){
                if(runningSum + i > maxSum) break;
                runningSum += i;
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] banned = {11};
        int n  = 7;
        int maxSum = 50;
        MaximumIntegersToChoose_2554 sol = new MaximumIntegersToChoose_2554();
        System.out.println(sol.maxCount(banned, n, maxSum));

    }
}
