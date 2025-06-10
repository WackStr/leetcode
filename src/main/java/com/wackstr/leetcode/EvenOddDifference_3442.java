package com.wackstr.leetcode;

/*
2025-06-10
 */
public class EvenOddDifference_3442 {
    public int maxDifference(String s){
        int[] cnt = new int[26];
        int minEven = s.length() + 1, maxOdd = 0;
        for(int i = 0; i < s.length(); i++){
            cnt[s.charAt(i) - 'a']++;
        }
        for (int j : cnt) {
            if (j != 0) {
                if (j % 2 == 0) {
                    minEven = Math.min(minEven, j);
                } else {
                    maxOdd = Math.max(maxOdd, j);
                }
            }
        }
        return maxOdd - minEven;
    }
}
