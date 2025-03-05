package com.wackstr.leetcode;

/*
2025-03-05
 */
public class ColoredCells_2579 {
    public long coloredCells(int n){
        long base = 2L * n;
        return base * n - base + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 100_000};
        ColoredCells_2579 sol = new ColoredCells_2579();
        for(int n : nums) {
            System.out.println(sol.coloredCells(n));
        }
    }
}
