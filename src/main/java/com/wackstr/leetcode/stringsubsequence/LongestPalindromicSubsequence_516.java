package com.wackstr.leetcode.stringsubsequence;

public class LongestPalindromicSubsequence_516 {
    /*
    you could find the longest common subsequence between s and its reverse
    here we are doing tabulation
    n x n grid
    where dp[i][j] means longest palindromic sequence from i to j where i <= j
    we start from dp[n-1][n-1] and go up a row scanning that row from i to n-1
    since current row depends on the last row scanned, we only track the two rows

     */
    public int longestPalindromeSubseq(String s){
        int n = s.length();
        int[] curr = new int[n];
        int[] next = new int[n];
        for(int i = n - 1; i >= 0; i--){
            for(int j = i; j < n; j++){
                if(i == j) {
                    curr[i] = 1;
                }else if(s.charAt(i) == s.charAt(j)){
                    if(i + 1 == j) curr[j] = 2;
                    else curr[j] = 2 + next[j-1];
                }else{
                    curr[j] = Math.max(next[j], curr[j-1]);
                }
            }
            next = curr.clone();
        }
        return curr[n-1];
    }

    public static void main(String[] args) {
        String s = "bbbab";
        LongestPalindromicSubsequence_516 sol =
                new LongestPalindromicSubsequence_516();
        System.out.println(sol.longestPalindromeSubseq(s));
    }
}
