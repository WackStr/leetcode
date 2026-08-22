package com.wackstr.leetcode;

/*
2026-08-22 3622
 */
public class Divisbility_3622 {
    public boolean checkDivisibility(int n) {
        int m = n;
        int product = 1;
        int sum = 0;
        while(n > 0){
            int digit = n % 10;
            sum += digit;
            product *= digit;
            n /= 10;
        }
        return m % (sum + product) == 0;
    }

    public static void main(String[] args) {
        int n = 23;
        Divisbility_3622 sol = new Divisbility_3622();
        System.out.println(sol.checkDivisibility(n));
    }
}
