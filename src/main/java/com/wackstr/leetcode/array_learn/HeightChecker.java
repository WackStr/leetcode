package com.wackstr.leetcode.array_learn;

import java.util.Arrays;

public class HeightChecker {
    public int heightChecker(int[] heights){
        int[] expected =
                Arrays.copyOf(heights, heights.length);
        Arrays.sort(expected);
        int difference = 0;
        for(int i = 0; i < heights.length; i++){
            difference += heights[i] != expected[i] ? 1 : 0;
        }
        return difference;
    }

    public static void main(String[] args) {
        int[] heights = {1, 1, 4, 2, 1, 3};
        HeightChecker sol = new HeightChecker();
        System.out.println(sol.heightChecker(heights));
    }
}
