package com.wackstr.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
2025-01-07
 */
public class StringMatchingInArray_1408 {
    public List<String> stringMatching(String[] words){
        List<String> substrings = new ArrayList<>();
        for(int i = 0; i < words.length; i++){
            String currWord = words[i];
            for(int j = 0; j < words.length; j++){
                if(j != i){
                    String tempWord = words[j];
                    if(tempWord.contains(currWord)){
                        substrings.add(currWord);
                        break;
                    }
                }
            }
        }
        return substrings;
    }

    public static void main(String[] args) {
        String[] words = {"mass","as","hero","superhero"};
        StringMatchingInArray_1408 sol = new StringMatchingInArray_1408();
        System.out.println(sol.stringMatching(words));
    }
}
