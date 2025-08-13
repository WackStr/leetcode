package com.wackstr.leetcode;

/*
2025-08-13
 */
public class PowerOfThree_326 {
    public boolean isPowerOfThree(int n){
        if(n < 1) return false;
        while(n > 1){
            if(n%3 != 0) return false;
            n /= 3;
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 28;
        PowerOfThree_326 sol = new PowerOfThree_326();
        System.out.println(sol.isPowerOfThree(n));
    }
}
