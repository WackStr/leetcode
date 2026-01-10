package com.wackstr.leetcode;

/*
2026-01-10 712
 */
public class MinimumStringDeletion_712 {
    public int minimumDeleteSum(String s1, String s2) {
        int[][] dp = new int[s1.length()+1][s2.length()+1];

        for(int i = s1.length() - 1; i >= 0; i--)
            dp[i][s2.length()] = s1.charAt(i) + dp[i+1][s2.length()];
        for(int i = s2.length() - 1; i >= 0; i--)
            dp[s1.length()][i] = s2.charAt(i) + dp[s1.length()][i+1];

        for(int i = s1.length() - 1; i >= 0; i--){
            for(int j = s2.length() - 1; j >= 0; j--){
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(j);
                int take =  dp[i+1][j+1];
                if(c1 != c2) {
                    take += c1 + c2;
                    take = Math.min(take, dp[i+1][j] + c1);
                    take = Math.min(take, dp[i][j+1] + c2);
                }
                dp[i][j] = take;
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        String s1 = "sea";
        String s2 = "eat";
        MinimumStringDeletion_712 sol = new MinimumStringDeletion_712();
        System.out.println(sol.minimumDeleteSum(s1, s2));
    }
}
