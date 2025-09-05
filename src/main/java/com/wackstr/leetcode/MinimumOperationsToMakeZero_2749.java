package com.wackstr.leetcode;

/*
2025-09-05
 */
public class MinimumOperationsToMakeZero_2749 {

    public int makeTheIntegerZero(int num1, int num2) {
        int k = 1;
        while (true) {
            long x = num1 - (long) num2 * k;
            if (x < k) {
                return -1;
            }
            if (k >= Long.bitCount(x)) {
                return k;
            }
            k++;
        }
    }

    public static void main(String[] args) {
        int num1 = 3;
        int num2 = -2;
        MinimumOperationsToMakeZero_2749 sol =
                new MinimumOperationsToMakeZero_2749();
        System.out.println(sol.makeTheIntegerZero(num1, num2));
    }

}
