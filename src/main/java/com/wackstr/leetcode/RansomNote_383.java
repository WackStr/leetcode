package com.wackstr.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RansomNote_383 {
    public boolean canConstruct(String ransomNote, String magazine){
        int[] arr = new int[26];
        for(int i = 0; i < ransomNote.length(); i++){
            arr[ransomNote.charAt(i) - 'a']++;
        }
        for(int i = 0; i < magazine.length(); i++){
            arr[magazine.charAt(i) - 'a']--;
        }
        for(int i = 0; i < 26; i++){
            if(arr[i] > 0) return false;
        }
        return true;
    }

    private static boolean dictionarySolution(String ransomNote, String magazine) {
        Map<Character, Integer> lookup = new HashMap<>();
        for(int i = 0; i < ransomNote.length(); i++){
            lookup.merge(
                    ransomNote.charAt(i),
                    1,
                    Integer::sum);
        }
        for(int i = 0; i < magazine.length(); i++){
            lookup.computeIfPresent(
                    magazine.charAt(i),
                    (k,v) -> v - 1 == 0 ? null : v - 1);
        }
        return lookup.isEmpty();
    }

    public static void main(String[] args) {
        String ransomNote = "aa", magazine = "aab";
        RansomNote_383 sol = new RansomNote_383();
        System.out.println(sol.canConstruct(ransomNote, magazine));
    }
}
