package com.wackstr.leetcode;

/*
2025-04-21
 */
public class HiddenSequences_2145 {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int x = 0, y = 0, cur = 0;
        for (int d : differences) {
            cur += d;
            x = Math.min(x, cur);
            y = Math.max(y, cur);
            if (y - x > upper - lower) {
                return 0;
            }
        }
        return (upper - lower) - (y - x) + 1;
    }

    public static void main(String[] args) {
        int[] differences = {-40};
        int lower = -46;
        int upper = 53;
        HiddenSequences_2145 sol = new HiddenSequences_2145();
        System.out.println(sol.numberOfArrays(differences, lower, upper));
    }
}
