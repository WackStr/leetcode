package com.wackstr.leetcode;


/*
2026-08-06 3345
 */
public class DivisibleNumber_3345 {
    public int smallestNumber(int n, int t){
        int x = getProduct(n);
        while(x % t != 0){
            n++;
            x = getProduct(n);
        }
        return n;
    }

    private int getProduct(int n) {
        int res = 1;
        while(n > 0){
            res *= (n % 10);
            n /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 10;
        int t = 2;
        DivisibleNumber_3345 sol = new DivisibleNumber_3345();
        System.out.println(sol.smallestNumber(n, t));
    }
}
