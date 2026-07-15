package com.wackstr.leetcode;

/*
2026-07-15
 */
public class EvenOddSumGCD_3658 {
    public int gcdOfOddEvenSums(int n){
        /*
        int i = 1 ... n
        2k -> 2.n(n+1)/2 = n(n+1) = n ^ 2 + n

        int i = 1 ... n
        2k - 1 -> 2.n(n+1)/2 - n = n(n+1) - n = n ^ 2

       n ^ 2 + n = [n^2].1 + n
       n ^ 2 = [n].[n] + 0

       n = 1
       1 + 3 = 4
       2 + 4 = 6
       6 = 4 x 1 + 2
       4 = 2 x 2 + 0
       gcd = 2
         */
        return n;
    }

    public static void main(String[] args) {
        int n = 4;
        EvenOddSumGCD_3658 sol = new EvenOddSumGCD_3658();
        System.out.println(sol.gcdOfOddEvenSums(n));
    }
}
