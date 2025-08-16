package com.wackstr.leetcode;

/*
2025-08-16
 */
public class SixNine_1323 {

    public int maximum69Number (int num){
        int digitPlace = getDigitPlace(num);
        return replaceFirstSix(num, digitPlace);
    }

    private static int replaceFirstSix(int num, int digitPlace) {
        int res = 0;
        boolean matched = false;
        int curr;
        while(digitPlace > 0) {
            res *= 10;
            curr = num / digitPlace;
            num -= curr * digitPlace;
            if (!matched && curr == 6) {
                curr = 9;
                matched = true;
            }
            res += curr;
            digitPlace /= 10;
        }
        return res;
    }

    private static int getDigitPlace(int num) {
        int digitPlace = 1;
        while(num / digitPlace > 0){
            digitPlace *= 10;
        }
        digitPlace /= 10;
        return digitPlace;
    }

    public static void main(String[] args) {
        int num = 9669;
        SixNine_1323 sol = new SixNine_1323();
        System.out.println(sol.maximum69Number(num));
    }
}
