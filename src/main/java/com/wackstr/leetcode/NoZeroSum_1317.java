package com.wackstr.leetcode;

import java.util.Arrays;

/*
2025-09-08
 */
public class NoZeroSum_1317 {
    public int[] getNoZeroIntegers(int n){
        for(int i = 1; i < n; i++){
            if(isNonZero(i) && isNonZero(n-i))
                return new int[]{i, n-i};
        }
        return null;
    }

    private boolean isNonZero(int i) {
        while(i > 0){
            if(i%10 == 0) return false;
            i /= 10;
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 11;
        NoZeroSum_1317 sol = new NoZeroSum_1317();
        System.out.println(Arrays.toString(sol.getNoZeroIntegers(n)));
    }
}
