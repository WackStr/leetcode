package com.wackstr.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
2025-07-15
 */
public class ValidWord_3136 {

    private static final Set<Character> digits =
            new HashSet<>(Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9'));
    private static final Set<Character> vowels =
            new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
    private static final Set<Character> symbols =
            new HashSet<>(Arrays.asList('@', '#', '$'));

    public boolean isValid(String word){
        if(word.length() < 3) return false;
        boolean vowel = false;
        boolean consonant = false;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(symbols.contains(c)) return false;
            if(vowels.contains(c)) vowel = true;
            else if(!digits.contains(c)) consonant = true;
        }
        return vowel && consonant;
    }

    public static void main(String[] args) {
        String word = "a3$e";
        ValidWord_3136 sol = new ValidWord_3136();
        System.out.println(sol.isValid(word));
    }
}
