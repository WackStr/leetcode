package com.wackstr.leetcode;

import java.util.Arrays;

/*
2026-03-30 2840
 */
public class StringEquality_2840 {
    public boolean checkStrings(String s1, String s2){
        
        int n = s1.length();
        int[] even1 = new int[26];
        int[] even2 = new int[26];
        int[] odd1 = new int[26];
        int[] odd2 = new int[26];
        
        for(int i = 0; i < n; i += 2)
            even1[s1.charAt(i)-'a']++;

        for(int i = 1; i < n; i += 2)
            odd1[s1.charAt(i)-'a']++;

        for(int i = 0; i < n; i += 2)
            even2[s2.charAt(i)-'a']++;

        for(int i = 1; i < n; i += 2)
            odd2[s2.charAt(i)-'a']++;
        
        return Arrays.equals(even1, even2) && Arrays.equals(odd1, odd2);
    }

    public static void main(String[] args) {
        String s1 = "abe", s2 = "bea";
        StringEquality_2840 sol = new StringEquality_2840();
        System.out.println(sol.checkStrings(s1, s2));
    }
}
