package com.wackstr.leetcode;

/*
2026-08-14 3090
 */
public class LongestSubstring_3090 {
    public int maximumLengthSubstring(String s) {
        int[] counts = new int[26];
        char[] arr = s.toCharArray();
        int res = 0;
        int left = 0;
        for (int right = 0; right < arr.length; right++) {
            int index = arr[right] - 'a';
            counts[index]++;
            while(counts[index] > 2){
                counts[arr[left]-'a'] = Math.max(counts[arr[left]-'a'] - 1, 0);
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "bcbbbcba";
        LongestSubstring_3090 sol = new LongestSubstring_3090();
        System.out.println(sol.maximumLengthSubstring(s));
    }
}
