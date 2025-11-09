package com.wackstr.leetcode;

/*
2025-11-09
 */
public class NumOperations_2169 {
    public int countOperations(int num1, int num2){
        int res = 0;
        int steps;
        int temp;
        while(num1 != 0 && num2 != 0){
            steps = num1/num2;
            temp = num2;
            res += steps;
            num1 %= num2;
            num2 = num1;
            num1 = temp;
        }
        return res;
    }
}
