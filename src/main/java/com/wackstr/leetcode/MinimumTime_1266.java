package com.wackstr.leetcode;

/*
2026-01-12 1266
 */
public class MinimumTime_1266 {
    public int minTimeToVisitAllPoints(int[][] points){
        int[] currPoint = points[0];
        int distance = 0;
        for (int i = 1; i < points.length; i++) {
            int[] point = points[i];
            distance += getTime(currPoint, point);
            currPoint = point;
        }
        return distance;
    }

    private int getTime(int[] a, int[] b) {
        int dx = Math.abs(b[0] - a[0]);
        int dy = Math.abs(b[1] - a[1]);
        int diagonal = Math.min(dx, dy);
        int direct = Math.max(dx, dy) - diagonal;
        return diagonal + direct;
    }

    public static void main(String[] args) {
        int[][] points = {{1,1}, {3,4}, {-1,0}};
        MinimumTime_1266 sol = new MinimumTime_1266();
        System.out.println(sol.minTimeToVisitAllPoints(points));
    }
}
