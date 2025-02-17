package com.wackstr.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
2025-02-17
 */
public class LetterTile_1079 {

    public int numTilePossibilities(String tiles) {
        // Track frequency of each uppercase letter (A-Z)
        int[] charCount = new int[26];
        for (char c : tiles.toCharArray()) {
            charCount[c - 'A']++;
        }

        // Find all possible sequences using character frequencies
        return findSequences(charCount);
    }

    private int findSequences(int[] charCount) {
        int totalCount = 0;

        // Try using each available character
        for (int pos = 0; pos < 26; pos++) {
            if (charCount[pos] == 0) {
                continue;
            }

            // Add current character and recurse
            totalCount++;
            charCount[pos]--;
            totalCount += findSequences(charCount);
            charCount[pos]++;
        }

        return totalCount;
    }

    public static void main(String[] args) {
        String tiles = "AAB";
        LetterTile_1079 sol = new LetterTile_1079();
        System.out.println(sol.numTilePossibilities(tiles));

    }
}
