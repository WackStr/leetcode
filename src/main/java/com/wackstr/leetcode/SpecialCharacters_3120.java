package com.wackstr.leetcode;

/*
2026-05-26 3120
 */
public class SpecialCharacters_3120 {
    /*
    a-z 97-122
    A-Z 65-90
     */
    public int numberOfSpecialChars(String word){
        int[] charLower = new int[26];
        int[] charUpper = new int[26];
        int res = 0;
        char[] arr = word.toCharArray();
        for (char c : arr) {
            int i = c - 'a';
            if(i >= 0){
                charLower[i]++;
            }else{
                charUpper[c-'A']++;
            }
        }
        for(int i = 0; i < 26; i++){
            if(charLower[i] > 0 && charUpper[i] > 0)res++;
        }
        return res;
    }

    public static void main(String[] args) {
        String word = "abBCab";
        SpecialCharacters_3120 sol = new SpecialCharacters_3120();
        System.out.println(sol.numberOfSpecialChars(word));
    }
}
