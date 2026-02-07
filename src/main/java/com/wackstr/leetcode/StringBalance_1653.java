package com.wackstr.leetcode;

/*
2026-02-07
 */
public class StringBalance_1653 {
    public int minimumDeletions(String s) {
        int bCount = 0;
        int deletions = 0;

        for (char c : s.toCharArray()) {
            if (c == 'b') {
                bCount++;
            } else {
                deletions = Math.min(deletions + 1, bCount);
            }
        }
        return deletions;
    }

    public static void main(String[] args) {
        String s = "baababbaabbaaabaabbabbbabaaaaaabaabababaaababbb";
        StringBalance_1653 sol = new StringBalance_1653();
        System.out.println(sol.minimumDeletions(s));
    }
}
