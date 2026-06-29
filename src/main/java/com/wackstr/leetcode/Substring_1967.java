package com.wackstr.leetcode;

/*
2026-06-29 1967
 */
public class Substring_1967 {
    public int numOfStrings(String[] patterns, String word){
        int res = 0;
        for (String pattern : patterns) {
            if(word.contains(pattern)) res++;
        }
        return res;
    }
}
