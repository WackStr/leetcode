package com.wackstr.leetcode;

import java.util.*;

/*
2025-09-11
 */
public class SortVowels_2785 {
    private static final Set<Character> VOWEL_SET =
            Set.of('a', 'e', 'i', 'o', 'u',
                    'A', 'E', 'I', 'O', 'U');
    public String sortVowels(String s){
        Queue<Integer> indexes = new LinkedList<>();
        Queue<Character> vowels = new PriorityQueue<>();
        char[] arr = s.toCharArray();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(VOWEL_SET.contains(c)){
                indexes.offer(i);
                vowels.offer(c);
            }
        }
        while(!indexes.isEmpty()){
            arr[indexes.poll()] = vowels.poll();
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        String s = "lEetcOde";
        SortVowels_2785  sol = new SortVowels_2785();
        System.out.println(sol.sortVowels(s));
    }
}
