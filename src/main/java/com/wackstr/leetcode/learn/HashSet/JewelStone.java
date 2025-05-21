package com.wackstr.leetcode.learn.HashSet;


public class JewelStone {
    public int numJewelsInStones(String jewels, String stones){
        boolean[] chars = new boolean['z'-'A' + 1];
        for(char c : jewels.toCharArray()){
            chars[c-'A'] = true;
        }
        int res = 0;
        for(char c : stones.toCharArray()){
            if(chars[c-'A']) res++;
        }
        return res;
    }

    public static void main(String[] args) {
        String jewels = "z";
        String stones = "ZZ";
        JewelStone sol = new JewelStone();
        System.out.println(sol.numJewelsInStones(jewels, stones));
    }
}
