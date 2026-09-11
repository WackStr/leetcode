package com.wackstr.leetcode;

/*
2026-09-11 3483
 */
public class UniqueDigits_3483 {
    public int totalNumbers(int[] digits) {
        boolean[] exists = new boolean[1000];
        for (int i = 0; i < digits.length; i++)
            for(int j = 0; j < digits.length; j++)
                for(int k = 0; k < digits.length; k++)
                    if(i != j && j != k && i != k && digits[i] != 0)
                        exists[digits[i] * 100 + digits[j] * 10 + digits[k]] = true;
        int res = 0;
        for(int i = 0; i < exists.length; i += 2) {
            if (exists[i]) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] digits = {0, 2, 2};
        UniqueDigits_3483 sol = new UniqueDigits_3483();
        System.out.println(sol.totalNumbers(digits));
    }
}
