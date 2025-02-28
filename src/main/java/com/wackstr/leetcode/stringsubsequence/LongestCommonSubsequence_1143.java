package com.wackstr.leetcode.stringsubsequence;

import java.util.Arrays;

/*
2025-02-28
 */
public class LongestCommonSubsequence_1143 {

    // bottom up dp with space optimization
    public int longestCommonSubsequence(String text1, String text2){
        int[] prev = new int[text2.length() + 1];
        int[] curr = new int[text2.length() + 1];

        for(int i = 1; i <= text1.length(); i++){
            for(int j = 1; j <= text2.length(); j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    curr[j] = 1 + prev[j - 1];
                }else{
                    curr[j] = Math.max(prev[j], curr[j-1]);
                }
            }
            prev = curr.clone();
        }

        return curr[text2.length()];
    }

    private int memoized(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return lcs(text1, text2, 0, 0, dp);
    }

    // recursive approach with memoization
    private int lcs(String text1, String text2, int i, int j, int[][] dp) {

        if(i >= text1.length() || j >= text2.length()) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int sequenceLength;
        if(text1.charAt(i) == text2.charAt(j)){
            sequenceLength = 1 + lcs(text1, text2, i + 1, j + 1, dp);
        }else{
            sequenceLength = Math.max(
                    lcs(text1, text2, i + 1, j, dp),
                    lcs(text1, text2, i, j + 1, dp)
            );
        }
        dp[i][j] = sequenceLength;
        return sequenceLength;
    }

    public static void main(String[] args) {
        String text1 = "abcba", text2 = "abcbcba";
        LongestCommonSubsequence_1143 sol = new LongestCommonSubsequence_1143();
        System.out.println(sol.longestCommonSubsequence(text1, text2));
    }
}
