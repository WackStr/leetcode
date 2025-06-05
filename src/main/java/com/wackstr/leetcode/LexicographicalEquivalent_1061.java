package com.wackstr.leetcode;

import java.util.Arrays;

/*
2025-06-05
 */
public class LexicographicalEquivalent_1061 {

    private static class UnionFind{

        private final char[] equivalence = new char[26];
        private final int[] groupSize = new int[26];
        // for traversal at end
        private final char[] lowest = new char[26];

        public UnionFind(){
            for(int i = 0; i < equivalence.length; i++){
                equivalence[i] = (char)('a' + i);
                lowest[i] = (char)('a' + i);
            }
            Arrays.fill(groupSize, 1);
        }

        private char find(char c) {
            if(equivalence[c - 'a'] == c) return c;
            // path compression
            char parent = find(equivalence[c - 'a']);
            equivalence[c - 'a'] = parent;
            return parent;
        }

        public void union(char c1, char c2) {
            char p1 = find(c1);
            char p2 = find(c2);
            int i1 = p1 - 'a';
            int i2 = p2 - 'a';
            if(p1 == p2) return;
            if(groupSize[i1] > groupSize[i2]) {
                equivalence[i2] = p1;
                groupSize[i1] += groupSize[i2];
            } else {
                equivalence[i1] = p2;
                groupSize[i2] += groupSize[i1];
            }
        }

        public void updateMinMapping() {
            for (int i = 0; i < 26; i++){
                char c = (char)('a' + i);
                char parent = find(c);
                int k = parent - 'a';
                if(c < lowest[k]) lowest[k] = c;
            }
        }

        public char findLowest(char k){
            return lowest[find(k) - 'a'];
        }
    }
    public String smallestEquivalentString(String s1, String s2, String baseStr){
        UnionFind uf = new UnionFind();
        for(int i = 0; i < s1.length(); i++){
            uf.union(s1.charAt(i), s2.charAt(i));
        }
        uf.updateMinMapping();
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < baseStr.length(); i++){
            res.append(uf.findLowest(baseStr.charAt(i)));
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "world";
        String baseStr = "hold";
        LexicographicalEquivalent_1061 sol = new LexicographicalEquivalent_1061();
        System.out.println(sol.smallestEquivalentString(s1, s2, baseStr));
    }


}
