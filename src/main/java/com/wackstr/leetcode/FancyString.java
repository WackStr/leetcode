package com.wackstr.leetcode;

/*
1957 - 2024-11-01
 */
public class FancyString {

    public String makeFancyString(String s) {
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            if(i <= 1){
                ans.append(curr);
            }else{
                char first = s.charAt(i-2);
                char second = s.charAt(i-1);
                if(first != second || curr != second){
                    ans.append(curr);
                }
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "leeetcode";
        FancyString sol = new FancyString();
        System.out.println(sol.makeFancyString(s));
    }
}
