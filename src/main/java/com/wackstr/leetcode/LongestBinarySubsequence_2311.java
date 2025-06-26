package com.wackstr.leetcode;

/*
2025-06-26
 */
public class LongestBinarySubsequence_2311 {
    public int longestSubsequence(String s, int k) {
        int sm = 0;
        int cnt = 0;
        int bits = (int) (Math.log(k) / Math.log(2)) + 1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(s.length() - 1 - i);
            if (ch == '1') {
                if (i < bits && sm + (1 << i) <= k) {
                    sm += 1 << i;
                    cnt++;
                }
            } else {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        String s = "1001111";
        int k = 5;
        LongestBinarySubsequence_2311 sol = new LongestBinarySubsequence_2311();
        System.out.println(sol.longestSubsequence(s, k));
    }


}
