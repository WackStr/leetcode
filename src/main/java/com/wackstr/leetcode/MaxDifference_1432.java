package com.wackstr.leetcode;

import java.util.Arrays;

/*
2025-06-15
 */
public class MaxDifference_1432 {
    public int maxDiff(int num){
        int[] digits = new int[9], max, min;
        int numDigits = 0, i = 8, t = num, k, replace;

        // convert the num into an array of digits
        while(t > 0){
            digits[i] = t % 10;
            i--;
            numDigits++;
            t /= 10;
        }

        // we will create the maximum and minim possible using the operations
        max = Arrays.copyOf(digits, digits.length);
        min = Arrays.copyOf(digits, digits.length);

        // find first index that is not 9
        i = 9 - numDigits;
        while(i < 9 && digits[i] == 9) i++;
        /*
         if a valid index convert all numbers at the index to 9
         this gives the maximum number
         */
        if(i < 9){
            for(k = 9 - numDigits; k < 9; k++){
                if(max[k] == digits[i]) max[k] = 9;
            }
        }

        // find the first index of character that is not 1 or 0
        i = 9 - numDigits;
        while(i < 9 && (digits[i] == 1 || digits[i] == 0)) i++;
        /*
        if valid index, convert to 1 if this is the first character (since
        we cannot have leading 0's, and 0 otherwise to get minimum number
         */
        if(i < 9){
            // check if index is tracking first digit or a later one
            replace = i > 9 - numDigits ? 0 : 1;
            for(k = 9 - numDigits; k < 9; k++){
                if(min[k] == digits[i]) min[k] = replace;
            }
        }

        // convert the digits to numbers and subtract for maximum difference
        return getVal(max, numDigits) - getVal(min, numDigits);
    }

    private int getVal(int[] digits, int numDigits) {
        int res = 0;
        int i = digits.length - numDigits;
        while(i < digits.length){
            res *= 10;
            res += digits[i];
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        int num = 1101057;
        MaxDifference_1432 sol = new MaxDifference_1432();
        System.out.println(sol.maxDiff(num));
    }
}
