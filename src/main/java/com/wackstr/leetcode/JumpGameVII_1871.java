package com.wackstr.leetcode;

/*
2026-05-25 1871
 */
public class JumpGameVII_1871 {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        if (s.charAt(n - 1) == '1') {
            return false;
        }

        boolean[] dp = new boolean[n];
        dp[0] = true;
        int j = 0;

        for (int i = 0; i < n; i++) {
            if (!dp[i]) {
                continue;
            }
            j = Math.max(j, i + minJump);
            while (j < Math.min(i + maxJump + 1, n)) {
                if (s.charAt(j) == '0') {
                    dp[j] = true;
                }
                j++;
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        String s = "0011101000";
        int minJump = 2;
        int maxJump = 4;
        JumpGameVII_1871 sol = new JumpGameVII_1871();
        System.out.println(sol.canReach(s, minJump, maxJump));
    }
}
