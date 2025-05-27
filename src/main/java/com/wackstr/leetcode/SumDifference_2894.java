package com.wackstr.leetcode;

/*
2025-05-27
 */
public class SumDifference_2894 {
    public int differenceOfSums(int n, int m){
        int num1 = 0;
        int num2 = 0;
        for(int i = 1; i <= n; i++){
            if(i % m == 0) num2 += i;
            else num1 += i;
        }
        return num1 - num2;
    }

    public static void main(String[] args) {
        int n = 5;
        int m = 6;
        SumDifference_2894 sol = new SumDifference_2894();
        System.out.println(sol.differenceOfSums(n, m));
    }
}
