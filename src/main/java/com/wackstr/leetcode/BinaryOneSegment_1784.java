package com.wackstr.leetcode;

/*
2026-03-06 1784
 */
public class BinaryOneSegment_1784 {
    public boolean checkOnesSegment(String s){
        int i = 0;
        while(i < s.length() && s.charAt(i) == '0') i++;
        while(i < s.length() && s.charAt(i) == '1') i++;
        while(i < s.length()) {
            if(s.charAt(i) == '1') return false;
            i++;
        }
        return true;
    }
}
