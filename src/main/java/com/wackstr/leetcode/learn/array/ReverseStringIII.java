package com.wackstr.leetcode.learn.array;

public class ReverseStringIII {
    public String reverseWords(String s){
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while(i < s.length()){
            while(i < s.length() && s.charAt(i) == ' '){
                sb.append(' ');
                i++;
            }
            StringBuilder word = new StringBuilder();
            while(i < s.length() && s.charAt(i) != ' '){
                word.append(s.charAt(i));
                i++;
            }
            sb.append(word.reverse());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        ReverseStringIII sol = new ReverseStringIII();
        System.out.println("|" + sol.reverseWords(s) + "|");
    }
}
