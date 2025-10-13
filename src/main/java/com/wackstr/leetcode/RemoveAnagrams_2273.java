package com.wackstr.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
2025-10-13
 */
public class RemoveAnagrams_2273 {
    public List<String> removeAnagrams(String[] words) {
        int[] map = new int[26];
        int[] nextMap = new int[26];
        List<String> res = new ArrayList<>();
        res.add(words[0]);
        computeMap(words[0], map);
        for(int i = 1; i < words.length; i++){
            computeMap(words[i], nextMap);
            if (!Arrays.equals(map, nextMap)) {
                res.add(words[i]);
                System.arraycopy(nextMap, 0, map, 0, map.length);
            }
        }
        return res;
    }

    private void computeMap(String word, int[] map) {
        Arrays.fill(map, 0);
        for(int i = 0; i < word.length(); i++){
            map[word.charAt(i) - 'a']++;
        }
    }

    public static void main(String[] args) {
        String[] words = {"abba","baba","bbaa","cd","cd"};
        RemoveAnagrams_2273 sol = new RemoveAnagrams_2273();
        System.out.println(sol.removeAnagrams(words));
    }
}
