package com.wackstr.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
2025-02-27
 */
public class LongestFibonnaciSubsequence_873 {
    public int lenLongestFibSubseq(int[] arr){
        int n = arr.length;
        int[][] dp = new int[n][n];
        Map<Integer, Integer> idxLookup = new HashMap<>();
        int maxLength = 0;
        for(int curr = 0; curr < n; curr++){
            idxLookup.put(arr[curr], curr);
            for(int prev = 0; prev < curr; prev++){
                int target = arr[curr] - arr[prev];
                int targetIndex = idxLookup.getOrDefault(target, -1);
                if(targetIndex < prev && targetIndex != -1){
                    dp[prev][curr] = dp[targetIndex][prev] + 1;
                }else{
                    dp[prev][curr] = 2;
                }
                maxLength = Math.max(maxLength, dp[prev][curr]);
            }
        }
        return maxLength == 2 ? 0 : maxLength;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        LongestFibonnaciSubsequence_873 sol = new LongestFibonnaciSubsequence_873();
        System.out.println(sol.lenLongestFibSubseq(arr));
    }

}
