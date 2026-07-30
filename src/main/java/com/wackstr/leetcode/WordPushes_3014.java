package com.wackstr.leetcode;

import java.util.Arrays;

/*
2026-07-30 3014
 */
public class WordPushes_3014 {

    private static final int CHARS = 26;
    private static final int KEYS = 8;
    private static final char BASE_CHAR = 'a';

    public int minimumPushes(String word) {
        int n = word.length();
        int m = (n - 1) / 8 + 1;
        return m * (m - 1) * 4 + (n - (m - 1) * 8) * m;
    }

    private static int withDuplicates(String word) {
        int[] cnt = new int[CHARS];
        char[] arr = word.toCharArray();
        for (char c : arr) {
            cnt[c - BASE_CHAR]++;
        }
        Arrays.sort(cnt);
        int res = 0;
        for (int i = CHARS - 1; i >= 0 && cnt[i] > 0; i--) {
            res += cnt[i] + (CHARS - i - 1) / KEYS;
        }
        return res;
    }

    public static void main(String[] args) {
        String word = "xycdefghij";
        WordPushes_3014 sol = new WordPushes_3014();
        System.out.println(sol.minimumPushes(word));
    }
}
