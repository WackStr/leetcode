package com.wackstr.leetcode;

/*
2026-06-13 3838
 */
public class WeightedWordMapping_3838 {
    public String mapWordWeights(String[] words, int[] weights) {
        char[] arr = new char[words.length];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int sum = 0;
            for (int j = 0; j < word.length(); j++) {
                sum += weights[(word.charAt(j) - 'a')];
            }
            arr[i] = (char)(25 - (sum % 26) + 'a');
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        String [] words = {"a","b","c"};
        int[] weights = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        WeightedWordMapping_3838 sol = new WeightedWordMapping_3838();
        System.out.println(sol.mapWordWeights(words, weights));
    }
}
