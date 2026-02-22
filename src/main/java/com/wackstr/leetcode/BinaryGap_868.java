package com.wackstr.leetcode;

/*
2026-02-22 868
 */
public class BinaryGap_868 {
    public int binaryGap(int n){
        int res = 0;
        int left = 30;
        int right  = 0;
        int leftMask = 1 << left;
        int rightMask = 1 << right;

        while((n & leftMask) == 0) {
            leftMask >>>= 1;
            left--;
        }
        while((rightMask & n) == 0) {
            rightMask <<= 1;
            right++;
        }
        for(int j = right + 1; j <= left; j++){
            int mask = 1 << j;
            if((n & mask) != 0) {
                res = Math.max(j - right, res);
                right = j;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 5;
        BinaryGap_868 sol = new BinaryGap_868();
        System.out.println(sol.binaryGap(n));
    }
}
