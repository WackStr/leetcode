package com.wackstr.leetcode;

/*
2026-11-05 1385
 */
public class ArrayDistance_1385 {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int cnt = 0;
        for (int i : arr1) {
            boolean count = true;
            for (int j : arr2) {
                if(Math.abs(i - j) <= d) {
                    count = false;
                    break;
                }
            }
            if(count) cnt++;
        }
        return cnt;
    }
}
