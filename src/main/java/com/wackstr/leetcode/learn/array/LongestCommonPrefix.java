package com.wackstr.leetcode.learn.array;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs){
        if(strs.length == 0) return "";
        int i = 0;
        StringBuilder sb = new StringBuilder();
        boolean shouldBreak = false;
        while(true){
            if(i < strs[0].length()){
                char baseChar = strs[0].charAt(i);
                for(int j = 1; j < strs.length; j++){
                    String str = strs[j];
                    if(i >= str.length() || str.charAt(i) != baseChar){
                        shouldBreak = true;
                        break;
                    }
                }
                if(shouldBreak) break;
                sb.append(baseChar);
                i++;
            }else{
                break;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        LongestCommonPrefix sol = new LongestCommonPrefix();
        System.out.println(sol.longestCommonPrefix(strs));
    }
}
