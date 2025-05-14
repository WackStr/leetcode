package com.wackstr.leetcode.learn.HashMap;

import java.util.HashMap;
import java.util.HashSet;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t){


        // character mapping from s1 to s2
        HashMap<Character, Character> m1 = new HashMap<>();

        // Already mapped characters in s2
        HashSet<Character> set2 = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i), c2 = t.charAt(i);

            // If c1 is already mapped
            if (m1.containsKey(c1)) {

                // Check if it maps to the current character in s2
                if (m1.get(c1) != c2) return false;

            } else {

                // Ensure c2 is not already mapped to another character
                if (set2.contains(c2)) return false;

                // Create a new mapping and mark c2 as mapped
                m1.put(c1, c2);
                set2.add(c2);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "paper";
        String t = "title";
        IsomorphicStrings sol = new IsomorphicStrings();
        System.out.println(sol.isIsomorphic(s, t));
    }
}
