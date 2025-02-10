package com.wackstr.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
2024-12-10
 */
public class LongestSpecialSubstring_2981 {
    public int maximumLength(String s) {
        int max = -1;
        int n = s.length();
        Map<Character, Map<Integer, Integer>> lookup = new HashMap<>();
        int left = 0, right = 0;
        while(left < n) {
            char leftChar = s.charAt(left);
            while(right < n) {
                char rightChar = s.charAt(right);
                if (leftChar == rightChar) {
                    int length = right - left + 1;
                    int cnt = lookup.computeIfAbsent(leftChar, k -> new HashMap<>())
                            .getOrDefault(length, 0) + 1;
                    lookup.get(leftChar).put(length, cnt);
                    if (cnt >= 3) {
                        max = Math.max(max, length);
                    }
                    right++;
                }else{
                    break;
                }
            }
            left++;
            right = left;
        }
        return max;
    }

    private static int maximumLength_fullStringKey(String s) {
        int max = -1;
        int n = s.length();
        Map<String, Integer> lookup = new HashMap<>();
        int left = 0, right = 0;
        while(left < n) {
            char leftChar = s.charAt(left);
            while(right < n) {
                char rightChar = s.charAt(right);
                if (leftChar == rightChar) {
                    String substr = s.substring(left, right + 1);
                    int cnt = lookup.getOrDefault(substr, 0) + 1;
                    lookup.put(substr, cnt);
                    if (cnt >= 3) {
                        max = Math.max(max, substr.length());
                    }
                    right++;
                }else{
                    break;
                }
            }
            left++;
            right = left;
        }
        return max;
    }

    private static int maximumLength_notSpecial(String s) {
        int max = -1;
        int n = s.length();
        Map<String, Integer> lookup = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            for(int length = 1; length <= n - i; length++){
                String substr = s.substring(i, i + length);
                int cnt = lookup.getOrDefault(substr, 0) + 1;
                lookup.put(substr, cnt);
                if(cnt >= 3){
                    max = Math.max(max, substr.length());
                }
            }
        }
        return max;
    }


    public static void main(String[] args) {
        String s = "cccerrrecdcdccedecdcccddeeeddcdcddedccdceeedccecde";
        LongestSpecialSubstring_2981 sol = new LongestSpecialSubstring_2981();
        System.out.println(sol.maximumLength(s));
    }
}
