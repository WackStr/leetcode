package com.wackstr.leetcode;

/*
2025-09-27
 */
public class LargestTriangle_812 {
    public double largestTriangleArea(int[][] points){
        double max = 0;
        for(int i = 0; i < points.length; i++){
            int[] p1 = points[i];
            for(int j = i + 1; j < points.length; j++){
                int[] p2 = points[j];
                for(int k = j + 1; k < points.length; k++){
                    int[] p3 = points[k];
                    max = Math.max(max, getArea(p1, p2, p3));
                }
            }
        }
        return max;
    }

    private double getArea(int[] p1, int[] p2, int[] p3) {
        return 0.5 * Math.abs(
                p1[0] * (p2[1] - p3[1]) +
                p2[0] * (p3[1] - p1[1]) +
                p3[0] * (p1[1] - p2[1]));
    }

}
