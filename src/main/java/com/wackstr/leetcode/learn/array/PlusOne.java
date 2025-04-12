package com.wackstr.leetcode.learn.array;

import java.util.Arrays;

public class PlusOne {
    public int[] plusOne(int[] digits){
        int carry = 1;
        for(int i = digits.length - 1; i >= 0; i--){
            digits[i] = digits[i] + carry;
            if(digits[i] <= 9) {
                carry = 0;
                break;
            }else{
                carry = 1;
                digits[i] = 0;
            }
        }
        if (carry == 0) return digits;
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        System.arraycopy(digits, 0, res, 1, res.length - 1);
        return res;
    }

    public static void main(String[] args) {
        int[] digits = {9};
        PlusOne sol = new PlusOne();
        System.out.println(Arrays.toString(sol.plusOne(digits)));
    }
}
