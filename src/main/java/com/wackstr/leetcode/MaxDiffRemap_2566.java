package com.wackstr.leetcode;

/*
2025-06-14
 */
public class MaxDiffRemap_2566 {
    public int minMaxDifference(int num){
        int[] digits = new int[9];
        int temp = num;
        int minReplace = 0;
        int numDigits = 0;
        int i = digits.length - 1;
        while(temp > 0){
            minReplace = temp % 10;
            digits[i] = minReplace;
            temp /= 10;
            i--;
            numDigits++;
        }
        int maxReplace = 0;
        i = digits.length - numDigits;
        while(i < digits.length && digits[i] == 9) i++;
        maxReplace = i < digits.length ? digits[i] : 10;
        int min = 0;
        int max = 0;
        for(i = digits.length - numDigits; i < digits.length ; i++){
            min *= 10;
            max *= 10;
            min += digits[i] == minReplace ? 0 : digits[i];
            max += digits[i] == maxReplace ? 9 : digits[i];
        }
        return max - min;
    }

    public static void main(String[] args) {
        int num = 9999;
        MaxDiffRemap_2566 sol = new MaxDiffRemap_2566();
        System.out.println(sol.minMaxDifference(num));
    }
}
