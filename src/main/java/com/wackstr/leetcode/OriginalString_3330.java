package com.wackstr.leetcode;

/*
2025-07-01
 */
public class OriginalString_3330 {
    public int possibleStringCount(String word) {
        int n = word.length(), ans = 1;
        for (int i = 1; i < n; ++i) {
            if (word.charAt(i - 1) == word.charAt(i)) {
                ++ans;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String word = "abbcccc";
        OriginalString_3330 sol = new OriginalString_3330();
        System.out.println(sol.possibleStringCount(word));
    }
}
