package com.wackstr.leetcode;

/*
2025-01-15
 */
public class MinimizeXor_2429 {
    public int minimizeXor(int num1, int num2){
        int n = Integer.bitCount(num2);
        int minimizer = 0;
        while (n > 0 && num1 > 0) {
            int bitMask = Integer.highestOneBit(num1);
            minimizer ^= bitMask;
            num1 ^= bitMask;
            n--;
        }
        int currBit = 1;
        while(n > 0){
            if((currBit & minimizer) == 0) {
                minimizer ^= currBit;
                n--;
            }
            currBit <<= 1;
        }
        return minimizer;
    }

    public static void main(String[] args) {
        int num1 = 3;
        int num2 = 7;
        MinimizeXor_2429 sol = new MinimizeXor_2429();
        System.out.println(sol.minimizeXor(num1, num2));


    }
}
