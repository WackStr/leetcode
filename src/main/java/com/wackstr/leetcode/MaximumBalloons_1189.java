package com.wackstr.leetcode;

/*
2026-06-22 1189
 */
public class MaximumBalloons_1189 {

    // distinct chars of balloon
    private static final char[] DISTINCT_CHARS =
            {'b', 'a', 'l', 'o', 'n'};

    public int maxNumberOfBalloons(String test){
        int[] count = new int[26];
        char[] arr = test.toCharArray();
        for (char c : arr) {
            count[c - 'a']++;
        }
        // account for duplicate l and o in balloons
        count['l'-'a'] /= 2;
        count['o'-'a'] /= 2;

        // least occurring character determines count
        int res = Integer.MAX_VALUE;
        for (char c : DISTINCT_CHARS) {
            res = Math.min(res, count[c - 'a']);
        }
        return res;
    }

    public static void main(String[] args) {
        String test = "leetcode";
        MaximumBalloons_1189 sol = new MaximumBalloons_1189();
        System.out.println(sol.maxNumberOfBalloons(test));
    }
}
