package com.wackstr.leetcode;

public class BeautifulBinaryString {

    public int minChanges(String s) {
        int count = 0;
        for (int i = 0; i < s.length() - 1; i += 2){
            char c1 = s.charAt(i);
            char c2 = s.charAt(i+1);
            if (c1 != c2){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "1001";
        BeautifulBinaryString sol = new BeautifulBinaryString();
        System.out.println(sol.minChanges(s));
    }

}
