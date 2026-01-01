package com.wackstr.leetcode;

import java.util.Arrays;

/*
2026-01-01 66
 */
public class PlusOne_66 {

    public int[] plusOne(int[] digits){
        int nines = 0;
        for (int digit : digits) {
            if(digit == 9) nines++;
        }
        int[] res;
        if(nines == digits.length){
            res = new int[digits.length + 1];
            res[0] = 1;
        }else{
            res = new int[digits.length];
            System.arraycopy(digits, 0, res, 0, digits.length);
            int carry = 1;
            for (int i = digits.length - 1; i >= 0; i--) {
                int curr = res[i] + carry;
                res[i] = curr % 10;
                carry = curr / 10;
                if(carry == 0) break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] digits = {8, 9, 9, 9};
        PlusOne_66 sol = new PlusOne_66();
        System.out.println(Arrays.toString(sol.plusOne(digits)));
    }
}
