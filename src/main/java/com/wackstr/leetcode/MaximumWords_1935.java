package com.wackstr.leetcode;

/*
2025-09-15
 */
public class MaximumWords_1935 {
    public int canBeTypedWords(String text, String brokenLetters){
        boolean[] broken = new boolean[26];
        for(int i = 0; i < brokenLetters.length(); i++){
            broken[brokenLetters.charAt(i) - 'a'] = true;
        }
        String[] arr = text.split(" ");
        int res = 0;
        boolean canType;
        for(String word : arr){
            canType = true;
            for(int i = 0; i < word.length(); i++){
                if(broken[word.charAt(i) - 'a']){
                    canType = false;
                    break;
                }
            }
            if(canType) res++;
        }
        return res;
    }

    public static void main(String[] args) {
        String text = "leet code";
        String brokenLetters = "e";
        MaximumWords_1935 sol = new MaximumWords_1935();
        System.out.println(sol.canBeTypedWords(text, brokenLetters));
    }
}
