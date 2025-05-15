package com.wackstr.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
2025-05-15
 */
public class AdjacentGroups_2900 {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> ans = new ArrayList<>();
        int n = words.length;
        for (int i = 0; i < n; i++) {
            if (i == 0 || groups[i] != groups[i - 1]) {
                ans.add(words[i]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] words = {"d","a","v","b"};
        int[] groups = {1,0,0,1};
        AdjacentGroups_2900 sol = new AdjacentGroups_2900();
        System.out.println(sol.getLongestSubsequence(words, groups)) ;
    }
}
