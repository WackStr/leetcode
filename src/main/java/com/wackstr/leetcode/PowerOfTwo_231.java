package com.wackstr.leetcode;

public class PowerOfTwo_231 {
    public boolean isPowerOfTwo(int n){
        if(n <= 0) return false;
        while(n > 1){
            int lastBit = n & 1;
            if(lastBit != 0) return false;
            n >>= 1;
        }
        return true;
    }

    public static void main(String[] args) {
        PowerOfTwo_231 sol = new PowerOfTwo_231();
        System.out.println(sol.isPowerOfTwo(9));
    }
}
