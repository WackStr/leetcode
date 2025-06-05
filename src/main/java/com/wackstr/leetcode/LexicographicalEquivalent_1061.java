package com.wackstr.leetcode;

import java.util.Arrays;

/*
2025-06-05
 */
public class LexicographicalEquivalent_1061 {

    /*
    A union find structure that also marks the lexicographically smallest
    element of each group
     */
    private static class UnionFind {

        private static final int CHARS = 26;
        // group representative of each lowercase character
        private final char[] groups = new char[CHARS];
        // track size of each group
        private final int[] groupSize = new int[CHARS];
        // lexicographically lowest element marked against group representatives
        private final char[] lowest = new char[CHARS];

        public UnionFind(){
            // initialization
            for(int i = 0; i < groups.length; i++){
                char c = getChar(i);
                groups[i] = c; // each char is initially in its own group
                lowest[i] = c; // hence lowest char is itself
            }
            Arrays.fill(groupSize, 1); // groups start with size one
        }

        /*
        Find the group representative for a given character
         */
        private char find(char c) {
            int i = getIndex(c);
            if(groups[i] == c) return c;
            // path compression
            char parent = find(groups[i]);
            groups[i] = parent;
            return parent;
        }

        public void union(char c1, char c2) {
            char p1 = find(c1);
            char p2 = find(c2);
            if(p1 == p2) return;
            int i1 = getIndex(p1);
            int i2 = getIndex(p2);
            // merge the smaller group into the larger group
            if(groupSize[i1] > groupSize[i2]) {
                groups[i2] = p1;
                groupSize[i1] += groupSize[i2];
            } else {
                groups[i1] = p2;
                groupSize[i2] += groupSize[i1];
            }
        }

        /*
        To be invoked after all unions are done
         */
        public void updateMinMapping() {
            // go through chars and update lowest of parent if possible
            for (int i = 0; i < CHARS; i++){
                char c = getChar(i);
                char parent = find(c);
                int k = getIndex(parent);
                if(c < lowest[k]) lowest[k] = c;
            }
        }

        /*
         finding the lexicographically lowest against a char now becomes
         a lookup for its group
         */
        public char findLowest(char k){
            char parent = find(k);
            return lowest[getIndex(parent)];
        }

        // helper method
        private static char getChar(int i) {
            return (char) ('a' + i);
        }

        private static int getIndex(char c){
            return c - 'a';
        }
    }
    public String smallestEquivalentString(String s1, String s2, String baseStr){

        // use the union find structure to build the mapping
        UnionFind uf = new UnionFind();
        for(int i = 0; i < s1.length(); i++){
            uf.union(s1.charAt(i), s2.charAt(i));
        }
        uf.updateMinMapping();

        // use this mapping to find the lowest chars against baseStr
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
