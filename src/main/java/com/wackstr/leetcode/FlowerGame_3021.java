package com.wackstr.leetcode;

/*
2025-08-29
 */
public class FlowerGame_3021 {
    public long flowerGame(int n, int m){
        return (long) n / 2 * m + (n % 2 == 0 ? 0 : m/2);
    }
}
