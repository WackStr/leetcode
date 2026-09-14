package com.wackstr.leetcode;

/*
2026-09-14 836
 */
public class RectangleOverlap_836 {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        boolean notX = rec2[0] >= rec1[2] || rec2[2] <= rec1[0];
        boolean notY = rec2[1] >= rec1[3] || rec2[3] <= rec1[1];
        return !notX && !notY;
    }
}
