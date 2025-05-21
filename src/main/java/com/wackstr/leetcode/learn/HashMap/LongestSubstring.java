package com.wackstr.leetcode.learn.HashMap;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {
    /*
    Given a string s, find the length of the longest substring without
    duplicate characters.
     */
    public int lengthOfLongestSubstring(String s){
        Map<Character, Integer> lastIndex = new HashMap<>();
        int left = 0;
        int right = 0;
        int max = 0;
        while(right < s.length()){
            char c = s.charAt(right);
            if(lastIndex.containsKey(c) && lastIndex.get(c) >= left){
                left = lastIndex.get(c) + 1;
            }
            lastIndex.put(c, right);
            right++;
            max = Math.max(right - left, max);
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "abba";
        LongestSubstring sol = new LongestSubstring();
        System.out.println(sol.lengthOfLongestSubstring(s));
    }
}
