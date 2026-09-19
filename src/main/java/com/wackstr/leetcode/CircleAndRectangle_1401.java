package com.wackstr.leetcode;

/*
2026-09-19 1401
 */
public class CircleAndRectangle_1401 {
    public boolean checkOverlap(
            int radius,
            int xCenter,
            int yCenter,
            int x1,
            int y1,
            int x2,
            int y2
    ) {
        double dist = 0;
        if (xCenter < x1 || xCenter > x2) {
            dist += Math.min(
                    Math.pow(x1 - xCenter, 2),
                    Math.pow(x2 - xCenter, 2)
            );
        }
        if (yCenter < y1 || yCenter > y2) {
            dist += Math.min(
                    Math.pow(y1 - yCenter, 2),
                    Math.pow(y2 - yCenter, 2)
            );
        }
        return dist <= radius * radius;
    }

    public static void main(String[] args) {
        int radius = 10, xCenter = 10, yCenter = 1, x1 = 0, y1 = 0, x2 = 100, y2 = 100;

        CircleAndRectangle_1401 sol = new CircleAndRectangle_1401();
        System.out.println(sol.checkOverlap(radius, xCenter, yCenter, x1, y1, x2, y2));

    }
}
