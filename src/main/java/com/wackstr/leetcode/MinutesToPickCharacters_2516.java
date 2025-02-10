package com.wackstr.leetcode;

import java.util.*;

/*
2024-11-20
 */
public class MinutesToPickCharacters_2516 {

    public int takeCharacters(String s, int k) {
        if (k == 0) return 0;
        // initialize map
        Map<Character, Integer> map = getCharacterCounts(s);
        if(isInsufficient(map.values(), k)) return -1;

        int n = s.length();
        int left = 0;
        Map<Character, Integer> newMap = new HashMap<>();
        map.keySet().forEach(t -> newMap.put(t, 0));

        while(isInsufficient(newMap.values(), k)){
            newMap.merge(s.charAt(left), 1, Integer::sum);
            left++;
        }
        left--;

        int minimumWindow = left + 1;
        int right = n - 1;
        while(left >= 0){
            newMap.merge(s.charAt(left), -1, Integer::sum);
            left--;
            while(isInsufficient(newMap.values(), k)){
                newMap.merge(s.charAt(right), 1, Integer::sum);
                right--;
            }
            int currWindow = n - right + left;
            minimumWindow = Math.min(minimumWindow, currWindow);
        }
        return minimumWindow;
    }

    private static Map<Character, Integer> getCharacterCounts(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : new char[]{'a','b','c'}){
            map.put(c, 0);
        }
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            map.merge(c, 1, Integer::sum);
        }
        return map;
    }

    private boolean isInsufficient(Collection<Integer> vals, int k){
        for(Integer cnt : vals){
            if(cnt < k){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "a";
        int k = 1;
        MinutesToPickCharacters_2516 sol = new MinutesToPickCharacters_2516();
        System.out.println(sol.takeCharacters(s, k));
    }
}
