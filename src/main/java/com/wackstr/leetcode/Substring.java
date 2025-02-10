package com.wackstr.leetcode;

public class Substring {

    public int strStr(String haystack, String needle) {
        for(int i = 0; i < haystack.length(); i++) {
            if(haystack.charAt(i) == needle.charAt(0)){
                boolean ans = true;
                int j = 1;
                for(; j < needle.length() && i + j < haystack.length(); j++){
                    if(haystack.charAt(i+j) != needle.charAt(j)){
                        ans = false;
                        break;
                    }
                }
                if(ans && j == needle.length()){
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";

        Substring sol = new Substring();
        System.out.println(sol.strStr(haystack, needle));
    }
}
