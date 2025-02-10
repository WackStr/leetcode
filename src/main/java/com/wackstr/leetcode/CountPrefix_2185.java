package com.wackstr.leetcode;

/*
2025-01-09
 */
public class CountPrefix_2185 {
    public int prefixCount(String[] words, String pref){
        int cnt = 0;
        for(String word: words){
            cnt += word.startsWith(pref) ? 1 : 0;
        }
        return cnt;
    }

    public static void main(String[] args) {
        String[] words = {"pay","attention","practice","attend"};
        String pref = "at";
        CountPrefix_2185 sol  = new CountPrefix_2185();
        System.out.println(sol.prefixCount(words, pref));


    }
}
