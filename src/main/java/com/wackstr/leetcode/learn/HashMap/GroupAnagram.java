package com.wackstr.leetcode.learn.HashMap;

import java.util.*;

public class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs){
        Map<String, List<String>> grp = new HashMap<>();
        for(String str : strs){
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            grp.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(grp.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};

        GroupAnagram sol = new GroupAnagram();
        System.out.println(sol.groupAnagrams(strs));

    }
}
