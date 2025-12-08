package com.wackstr.leetcode;

import java.util.Arrays;

/*
2025-12-08 1925
 */
public class SquareSumTriples_1925 {
    public static int countTriples(int n) {
        int count = 0;

        for (int i = n; i > 0; i--) {
            int left = 1;
            int right = n - 1;
            while (right > left) {
                if (right * right + left * left > i * i) right--;
                 else left++;

                if (i * i == right * right + left * left) count += 2;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 10;
        SquareSumTriples_1925 sol = new SquareSumTriples_1925();
        System.out.println(sol.countTriples(n));
    }
}
