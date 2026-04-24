package com.wackstr.leetcode;

/*
2026-04-24 2833
 */
public class FurthestPoint_2833 {
    public int furthestDistanceFromOrigin(String moves){
        char[] arr = moves.toCharArray();
        int left = 0;
        int select = 0;
        int right = 0;
        for (char c : arr) {
            switch(c) {
                case 'L': left++; break;
                case 'R': right++; break;
                default: select++;
            }
        }
        return Math.abs(left-right)+select;
    }
}
