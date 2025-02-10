package com.wackstr.leetcode;

/*
2025-01-08
 */
public class CountPrefixAndSuffixPairs_3042 {
    public int countPrefixSuffixPairs(String[] words){
        int count = 0;
        for(int i = 0; i < words.length; i++){
            String str1 = words[i];
            for (int j = i + 1; j < words.length; j++){
                String str2 = words[j];
                count += str2.startsWith(str1) && str2.endsWith(str1) ? 1 : 0;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] words = {"a","aba","ababa","aa"};
        CountPrefixAndSuffixPairs_3042 sol = new CountPrefixAndSuffixPairs_3042();
        System.out.println(sol.countPrefixSuffixPairs(words));

    }
}
