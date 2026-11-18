package com.wackstr.leetcode;

/*
2026-11-18 2914
 */
public class BeautifulBinaryString_2914 {
    public int minChanges(String s) {
        int count = 0;
        for (int i = 0; i < s.length() - 1; i += 2){
            char c1 = s.charAt(i);
            char c2 = s.charAt(i+1);
            if (c1 != c2){
                count++;
            }
        }
        return count;
    }
}
