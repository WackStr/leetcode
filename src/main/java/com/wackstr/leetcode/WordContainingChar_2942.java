package com.wackstr.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
2025-05-24
 */
public class WordContainingChar_2942 {
    public List<Integer> findWordsContaining(String[] words, char c){
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < words.length; i++){
            String word = words[i];
            if(word.indexOf(c) != -1) res.add(i);
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words = {"abc", "bcd", "aaaa", "cbc"};
        char c = 'z';
        WordContainingChar_2942 sol = new WordContainingChar_2942();
        System.out.println(sol.findWordsContaining(words, c));
    }
}
