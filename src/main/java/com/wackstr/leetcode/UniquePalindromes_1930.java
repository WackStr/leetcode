package com.wackstr.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
2025-01-04
 */
public class UniquePalindromes_1930 {
    public int countPalindromicSubsequence(String s){
        Map<Character, Integer> counts = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            int currCount = 0;
            Set<Character> pivots = new HashSet<>();
            char root = s.charAt(i);
            if(!counts.containsKey(root)) {
                for (int j = i + 1; j < s.length(); j++) {
                    char currChar = s.charAt(j);
                    if(currChar == root && j > i + 1){
                        currCount = pivots.size();
                    }
                    pivots.add(currChar);
                }
                counts.put(root, currCount);
            }
        }
        int finalCount = 0;
        for(int val : counts.values()){
            finalCount += val;
        }
        return finalCount;
    }

    public static void main(String[] args) {
        String s = "bbcbaba";
        UniquePalindromes_1930 sol = new UniquePalindromes_1930();
        System.out.println(sol.countPalindromicSubsequence(s));
    }
}
