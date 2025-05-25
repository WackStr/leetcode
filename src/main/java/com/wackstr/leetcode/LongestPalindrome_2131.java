package com.wackstr.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
2025-05-25
 */
public class LongestPalindrome_2131 {
    public int longestPalindrome(String[] words) {
        // cnt[i][j] = how many times we've seen the word (char)i→(char)j
        int[][] cnt = new int[26][26];
        int res = 0;
        for (String w : words) {
            int x = w.charAt(0) - 'a';
            int y = w.charAt(1) - 'a';
            if (cnt[y][x] > 0) {
                // we can pair this "xy" with a previous "yx" to get a 4-letter palindrome
                cnt[y][x]--;
                res += 4;
            } else {
                // store "xy" for a future reverse match
                cnt[x][y]++;
            }
        }
        // if any same character word leftover
        // we can put exactly one in the middle
        for (int i = 0; i < 26; i++) {
            if (cnt[i][i] > 0) {
                res += 2;
                break;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        String[] words = {"ll","lb","bb","bx","xx","lx","xx","lx","ll","xb","bx","lb","bb","lb","bl","bb","bx","xl","lb","xx"};
        LongestPalindrome_2131 sol = new LongestPalindrome_2131();
        System.out.println(sol.longestPalindrome(words));
    }
}
