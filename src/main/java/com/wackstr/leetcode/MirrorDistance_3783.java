package com.wackstr.leetcode;

/*
2026-04-18 3783
 */
public class MirrorDistance_3783 {
    public int mirrorDistance(int n) {
        int m = n;
        int rev = 0;
        while(m > 0){
            rev = rev * 10 + m % 10;
            m /= 10;
        }
        return Math.abs(n - rev);
    }

    public static void main(String[] args) {
        int n = 7;
        MirrorDistance_3783 sol = new MirrorDistance_3783();
        System.out.println(sol.mirrorDistance(n));
    }
}
