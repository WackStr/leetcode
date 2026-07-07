package com.wackstr.leetcode;

/*
2026-07-07 3754
 */
public class DigitConcatenation_3754 {
    public long sumAndMultiply(int n){
        int x = 0;
        long sum = 0;
        int placeholder = 1;
        while(n > 0){
            int mod = n % 10;
            if(mod > 0){
                sum += mod;
                x += placeholder * mod;
                placeholder *= 10;
            }
            n /= 10;
        }
        return x * sum;
    }

    public static void main(String[] args) {
        int n = 10203004;
        DigitConcatenation_3754 sol = new DigitConcatenation_3754();
        System.out.println(sol.sumAndMultiply(n));
    }
}
