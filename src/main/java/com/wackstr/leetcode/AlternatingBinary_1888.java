package com.wackstr.leetcode;

/*
2026-03-07 1888
 */
public class AlternatingBinary_1888 {
    public int minFlips(String s) {
        int n = s.length();
        int[][] pre = new int[n][2];

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            // Compute the prefix array
            pre[i][0] = (i == 0 ? 0 : pre[i - 1][1]) + (ch == '1' ? 1 : 0);
            pre[i][1] = (i == 0 ? 0 : pre[i - 1][0]) + (ch == '0' ? 1 : 0);
        }

        int ans = Math.min(pre[n - 1][0], pre[n - 1][1]);
        // If the length is odd, consider the move operation
        if (n % 2 == 1) {
            int[][] suf = new int[n][2];
            for (int i = n - 1; i >= 0; i--) {
                char ch = s.charAt(i);
                // Suffix Array Construction
                suf[i][0] =
                        (i == n - 1 ? 0 : suf[i + 1][1]) + (ch == '1' ? 1 : 0);
                suf[i][1] =
                        (i == n - 1 ? 0 : suf[i + 1][0]) + (ch == '0' ? 1 : 0);
            }

            // Traverse all split points
            for (int i = 0; i < n - 1; i++) {
                ans = Math.min(ans, pre[i][0] + suf[i + 1][0]);
                ans = Math.min(ans, pre[i][1] + suf[i + 1][1]);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "111000";
        AlternatingBinary_1888 sol = new AlternatingBinary_1888();
        System.out.println(sol.minFlips(s));
    }
}
