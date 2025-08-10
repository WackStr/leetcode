package com.wackstr.leetcode;

import java.util.Arrays;

/*
2025-08-10
 */
public class ReorderedPowerOfTwo_869 {

    private static final int[][] lookup;

    static {
        lookup = new int[31][10];
        for(int i = 0; i < 31; i++){
            lookup[i] = countDigits(1 << i);
        }
    }

    public boolean reorderedPowerOf2(int n) {
        int[] src = countDigits(n);
        for(int[] ref : lookup){
            if(Arrays.equals(src, ref)) {
                return true;
            }
        }
        return false;
    }

    public static int[] countDigits(int n){
        int[] arr = new int[10];
        while(n > 0){
            arr[n%10]++;
            n /= 10;
        }
        return arr;
    }

    public static void main(String[] args) {
        ReorderedPowerOfTwo_869 sol = new ReorderedPowerOfTwo_869();
        System.out.println(sol.reorderedPowerOf2(10));
    }
}
