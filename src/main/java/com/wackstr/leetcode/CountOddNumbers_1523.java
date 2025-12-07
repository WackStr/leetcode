package com.wackstr.leetcode;

/*
2025-12-07 1523
 */
public class CountOddNumbers_1523 {
    public int countOdds(int low, int high) {
        return (high - low + 1)/2 +
                ((low % 2 == 1 && high % 2 == 1)
                        ? 1 : 0);
    }
}
