package com.wackstr.leetcode;

/*
2025-10-04
 */
public class WaterContainer_11 {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int res = 0;

        while (i < j) {
            res = Math.max(res, (j - i) * Math.min(height[i], height[j]));
            if (height[i] < height[j]) i++;
            else j--;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        WaterContainer_11 sol = new WaterContainer_11();
        System.out.println(sol.maxArea(height));
    }
}
