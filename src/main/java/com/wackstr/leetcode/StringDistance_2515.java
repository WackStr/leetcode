package com.wackstr.leetcode;

/*
2026-04-15 2515
 */
public class StringDistance_2515 {
    public int closestTarget(String[] words, String target, int startIndex) {
        if(words[startIndex].equals(target)) return 0;
        int n = words.length;
        for(int i = 1; i < n; i++)
            if(words[(startIndex + i) % n].equals(target) ||
            words[(startIndex - i + n) % n].equals(target))
                return i;
        return -1;
    }

    public static void main(String[] args) {
        String[] words = {"a", "b", "leetcode"};
        String target = "leetcode";
        int startIndex = 0;
        StringDistance_2515 sol = new StringDistance_2515();
        System.out.println(sol.closestTarget(words, target, startIndex));
    }
}
