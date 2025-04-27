package com.wackstr.leetcode.learn.array;

public class ReverseWord {
    public String reverseWords(String s){
        int i = s.length() - 1;
        StringBuilder sb = new StringBuilder();
        while(i >= 0 && s.charAt(i) == ' ') i--;
        while(i >= 0){
            StringBuilder word = new StringBuilder();
            while(i >= 0 && s.charAt(i) != ' ') word.append(s.charAt(i--));
            sb.append(word.reverse());
            while(i >= 0 && s.charAt(i) == ' ') i--;
            if(i >= 0) sb.append(' ');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "  hello   world   ";
        ReverseWord sol = new ReverseWord();
        System.out.println("|"+sol.reverseWords(s)+"|");
    }
}
