package com.wackstr.leetcode;

import java.util.Arrays;

/*
2026-08-27 3720
 */
public class LexicographicTarget_3720 {
    public String lexGreaterPermutation(String s, String target){
        char[] sArr = s.toCharArray();
        char[] tArr = target.toCharArray();
        int n = sArr.length;
        char[] permutation = new char[n];
        int[] counts = new int[26];
        for (char c : sArr) counts[c-'a']++;

        boolean solved = solve(0, permutation, tArr, counts,true);
        String res = new String(permutation);

        return  (solved && res.compareTo(target) > 0) ? res : "";
    }

    private boolean solve(int i, char[] permutation, char[] tArr, int[] counts, boolean limit) {
        if (i == permutation.length) {
            String res = new String(permutation);
            return res.compareTo(new String(tArr)) > 0;
        }

        if(limit) {
            char c = tArr[i];
            int k = (c - 'a');
            if (counts[k] > 0) {
                counts[k]--;
                permutation[i] = c;
                if (solve(i + 1, permutation, tArr, counts, true)) return true;
                counts[k]++;
            }

            do k++; while (k < counts.length && counts[k] == 0);
            if (k == counts.length) {
                return false;
            } else {
                permutation[i] = (char) ('a' + k);
                counts[k]--;
                return solve(i + 1, permutation, tArr, counts, false);
            }
        }else {
            int b = 0;
                while (b < counts.length && counts[b] == 0) b++;
                if (b == counts.length) {
                    return false;
                }
                permutation[i] = (char) ('a' + b);
                counts[b]--;
                return solve(i+1, permutation, tArr, counts, false);
        }
    }

    public static void main(String[] args) {
        String s = "ab";
        String target = "ab";
        LexicographicTarget_3720 sol = new LexicographicTarget_3720();
        System.out.println(sol.lexGreaterPermutation(s, target));
    }
}
