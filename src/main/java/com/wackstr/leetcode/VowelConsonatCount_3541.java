package com.wackstr.leetcode;

/*
2025-09-13
 */
public class VowelConsonatCount_3541 {
    public int maxFreqSum(String s){
        int[] charCount = new int[26];
        int vowelMax = 0;
        int consonantMax = 0;
        for(int i = 0; i < s.length(); i++){
            charCount[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < charCount.length; i++){
            if(i == 'a' - 'a' || i == 'e' - 'a' || i == 'i' - 'a' || i == 'o' - 'a' || i == 'u' - 'a'){
                vowelMax = Math.max(vowelMax, charCount[i]);
            }else{
                consonantMax = Math.max(consonantMax, charCount[i]);
            }
        }
        return vowelMax + consonantMax;
    }
}
