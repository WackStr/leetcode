package com.wackstr.leetcode;

import java.util.Arrays;
import java.util.Set;

/*
2025-01-02
 */
public class CountVowelStringInRanges_2559 {

    private static final Set<Character> VOWELS =
            Set.of('a', 'e', 'i', 'o', 'u');

    public int[] vowelStrings(String[] words, int[][] queries){
        int[] prefixSum = getCumulativeVowelStrings(words);
        return getQueryAnswers(queries, prefixSum);
    }

    private static int[] getQueryAnswers(int[][] queries, int[] prefixSum) {
        int[] ans = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            int[] query = queries[i];
            int range = getRange(prefixSum, query);
            ans[i] = range;
        }
        return ans;
    }

    private static int getRange(int[] prefixSum, int[] query) {
        int r = prefixSum[query[1]];
        int l = query[0] == 0 ? 0 : prefixSum[query[0] - 1];
        return r - l;
    }

    private int[] getCumulativeVowelStrings(String[] words) {
        int[] track = new int[words.length];
        int cnt = 0;
        for(int i = 0; i < words.length; i++){
            String word = words[i];
            if(isVowelString(word)){
                cnt++;
            }
            track[i] = cnt;
        }
        return track;
    }

    private boolean isVowelString(String word) {
        return
                VOWELS.contains(word.charAt(0)) &&
                        VOWELS.contains(word.charAt(word.length() - 1));
    }

    public static void main(String[] args) {
        String[] words = {"aba","bcb","ece","aa","e"};
        int[][] queries = {{0,2}, {1,4}, {1,1}};
        CountVowelStringInRanges_2559 sol = new CountVowelStringInRanges_2559();
        System.out.println(Arrays.toString(sol.vowelStrings(words, queries)));
    }
}
