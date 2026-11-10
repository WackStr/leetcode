package com.wackstr.leetcode;

import java.util.Arrays;

/*
2026-11-10 3693
 */
public class JumpingStairs_3693 {

    public int climbStairs(int n, int[] costs) {
        int a = 0,
                b = 0,
                c = 0;
        for (int i = 0; i < n; ++i) {
            int nxt = Math.min(Math.min(a + 9, b + 4), c + 1) + costs[i];
            a = b;
            b = c;
            c = nxt;
        }
        return c;
    }

    public static void main(String[] args) {
        int n = 4;
        int[] costs = {1,2,3,4};
        JumpingStairs_3693 sol = new JumpingStairs_3693();
        System.out.println(sol.climbStairs(n, costs));
    }
}
