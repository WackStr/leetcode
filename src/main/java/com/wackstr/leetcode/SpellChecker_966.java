package com.wackstr.leetcode;

import java.util.*;

/*
2025-09-14
 */
public class SpellChecker_966 {
    private Set<String> exactMatch;
    private Map<String, String> capitalMatch;
    private Map<String, String> vowelMatch;

    public String[] spellchecker(String[] wordlist, String[] queries) {
        exactMatch = new HashSet<>();
        capitalMatch = new HashMap<>();
        vowelMatch = new HashMap<>();

        for (String word: wordlist) {
            exactMatch.add(word);

            String wordlow = word.toLowerCase();
            capitalMatch.putIfAbsent(wordlow, word);

            String wordlowDV = devowel(wordlow);
            vowelMatch.putIfAbsent(wordlowDV, word);
        }

        String[] ans = new String[queries.length];
        int t = 0;
        for (String query: queries)
            ans[t++] = solve(query);
        return ans;
    }

    public String solve(String query) {
        if (exactMatch.contains(query))
            return query;

        String queryL = query.toLowerCase();
        if (capitalMatch.containsKey(queryL))
            return capitalMatch.get(queryL);

        String queryLV = devowel(queryL);
        if (vowelMatch.containsKey(queryLV))
            return vowelMatch.get(queryLV);

        return "";
    }

    public String devowel(String word) {
        StringBuilder ans = new StringBuilder();
        for (char c: word.toCharArray())
            ans.append(isVowel(c) ? '*' : c);
        return ans.toString();
    }

    public boolean isVowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }
}
