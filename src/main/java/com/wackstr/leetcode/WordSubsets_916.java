package com.wackstr.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
2025-01-10
 */
public class WordSubsets_916 {
    public List<String> wordSubsets(String[] words1, String[] words2){
        List<String> universalWords = new ArrayList<>();
        Map<Character, Integer> wordMap = getSuperSetMap(words2);
        for(String word : words1){
            if(isUniversal(word, wordMap)) universalWords.add(word);
        }
        return universalWords;
    }

    private Map<Character, Integer> getSuperSetMap(String[] words2) {
        Map<Character, Integer> wordMap = new HashMap<>();
        for(String word : words2){
            Map<Character, Integer> currWordMap = getWordMap(word);
            updateMap(wordMap, currWordMap);
        }
        return wordMap;
    }

    private boolean isUniversal(String word, Map<Character, Integer> wordMap) {
        Map<Character, Integer> currWordMap = getWordMap(word);
        for(Map.Entry<Character, Integer> entry: wordMap.entrySet()){
            if(entry.getValue() > currWordMap.getOrDefault(entry.getKey(), 0))
                return false;
        }
        return true;
    }

    private void updateMap(
            Map<Character, Integer> wordMap,
            Map<Character, Integer> currWordMap) {
        for(Map.Entry<Character, Integer> entry : currWordMap.entrySet()){
            wordMap.merge(entry.getKey(), entry.getValue(), Math::max);
        }
    }

    public Map<Character, Integer> getWordMap(String word){
        Map<Character, Integer> wordMap = new HashMap<>();
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            wordMap.merge(c, 1, Integer::sum);
        }
        return wordMap;
    }

    public static void main(String[] args) {
        String[] words1 = {"amazon","apple","facebook","google","leetcode"};
        String[] words2 = {"e","o"};
        WordSubsets_916 sol = new WordSubsets_916();
        System.out.println(sol.wordSubsets(words1, words2));
    }
}
