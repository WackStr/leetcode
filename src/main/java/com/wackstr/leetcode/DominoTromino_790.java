package com.wackstr.leetcode;

/*
2025-05-05
 */
public class DominoTromino_790 {

    private static final int MOD = 1_000_000_007;

    public int numTilings(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;

        long dp0 = 1, dp1 = 1, dp2 = 2, dpi = 0;
        for (int i = 3; i <= n; i++) {
            dpi = (2 * dp2 + dp0) % MOD;
            dp0 = dp1;
            dp1 = dp2;
            dp2 = dpi;
        }
        return (int) dpi;
    }

    public static void main(String[] args) {
        int n = 4;
        DominoTromino_790 sol = new DominoTromino_790();
        System.out.println(sol.numTilings(n));
    }
}
