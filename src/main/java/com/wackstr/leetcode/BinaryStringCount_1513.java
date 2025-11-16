package com.wackstr.leetcode;

/*
2025-11-16
 */
public class BinaryStringCount_1513 {
    
    private static final int MOD = 1_000_000_007;
    
    public int numSub(String s){
        int n = s.length();
        int res = 0;
        int left = 0;
        int right;
        while (left < n) {
            while(left < n && s.charAt(left) == '0') left++;
            right = left;
            while(right < n && s.charAt(right) == '1') {
                right++;
                res = (res + (right - left)) % MOD;
            }
            left = right;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "111111";
        BinaryStringCount_1513 sol = new BinaryStringCount_1513();
        System.out.println(sol.numSub(s));
    }
}
