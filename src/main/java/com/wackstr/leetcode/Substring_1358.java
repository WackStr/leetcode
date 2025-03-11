package com.wackstr.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
2025-03-11
 */
public class Substring_1358 {

    private static final int CHAR_COUNT = 3;

    public int numberOfSubstrings(String s){
        int start = 0;
        int end = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        int substringCount = 0;
        while(end < s.length()){
            charMap.merge(s.charAt(end), 1, Integer::sum);
            if(charMap.size() == CHAR_COUNT){
                while(charMap.size() == CHAR_COUNT && start <= end){
                    substringCount += s.length() - end;
                    charMap.computeIfPresent(s.charAt(start),
                            (k,v) -> v - 1 == 0 ? null : v - 1);
                    start++;
                }
            }
            end++;
        }
        return substringCount;
    }

    public int numberOfSubstrings_minPosition(String s) {
        int len = s.length();
        // Track last position of a, b, c
        int[] lastPos = { -1, -1, -1 };
        int total = 0;

        for (int pos = 0; pos < len; pos++) {
            // Update last position of current character
            lastPos[s.charAt(pos) - 'a'] = pos;

            // Add count of valid substrings ending at current position
            // If any character is missing, min will be -1
            // Else min gives leftmost required character position
            total += 1 + Math.min(lastPos[0], Math.min(lastPos[1], lastPos[2]));
        }

        return total;
    }

    public static void main(String[] args) {
        String s = "aaacb";
        Substring_1358 sol = new Substring_1358();
        System.out.println(sol.numberOfSubstrings(s));
    }
}
