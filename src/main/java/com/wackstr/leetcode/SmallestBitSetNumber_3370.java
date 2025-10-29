package com.wackstr.leetcode;

/*
2025-10-29
 */
public class SmallestBitSetNumber_3370 {
    public int smallestNumber(int n){
        int max = Integer.highestOneBit(n);
        for(int i = 1; i < max; i <<= 1) n |= i;
        return n;
    }
}
