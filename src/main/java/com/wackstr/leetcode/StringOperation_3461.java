package com.wackstr.leetcode;

/*
2025-10-23
 */
public class StringOperation_3461 {
    public boolean hasSameDigits(String s){
        int n = s.length();
        int[] digits = new int[n];
        for(int i = 0; i < n; i++){
            digits[i] = s.charAt(i) - '0';
        }
        for(int i = n; i > 2; i--){
            for(int j = 0; j < i - 1; j++){
                digits[j] = (digits[j] + digits[j+1]) % 10;
            }
        }
        return digits[0] == digits[1];
    }

    public static void main(String[] args) {
        String s = "323";
        StringOperation_3461 sol = new StringOperation_3461();
        System.out.println(sol.hasSameDigits(s));
    }
}
