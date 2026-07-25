package com.wackstr.leetcode;

/*
2026-07-25 3536
 */
public class DigitProduct_3536 {
    public int maxProduct(int n){
        int a = -1;
        int b = -1;
        while(n > 0){
            int c = n % 10;
            if(c > a) {
                b = a;
                a = c;
            }
            else if(c > b) b = c;
            n /= 10;
        }
        return a * b;
    }

    public static void main(String[] args) {
        int n = 31;
        DigitProduct_3536 sol = new DigitProduct_3536();
        System.out.println(sol.maxProduct(n));
    }
}
