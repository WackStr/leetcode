package com.wackstr.leetcode;

/*
2026-11-22 2124
 */
public class AbeforeB_2124 {
    public boolean checkString(String s){
        boolean foundB = false;
        char[] arr = s.toCharArray();
        for (char c : arr) {
            if(c == 'a' && foundB) return false;
            if(c == 'b') foundB = true;
        }
        return true;
    }
}
