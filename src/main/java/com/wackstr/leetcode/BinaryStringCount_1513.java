package com.wackstr.leetcode;

/*
2025-11-16
 */
public class BinaryStringCount_1513 {
    
    private static final int MOD = 1_000_000_007;

    public int numSub(String s){
        int onesStreak = 0 ;
        int res = 0;
        for(char ch : s.toCharArray()) {
            if (ch  == '1') {
                res = ( res + ++onesStreak) % MOD ;
            }
            else    onesStreak = 0 ;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "111111";
        BinaryStringCount_1513 sol = new BinaryStringCount_1513();
        System.out.println(sol.numSub(s));
    }
}
