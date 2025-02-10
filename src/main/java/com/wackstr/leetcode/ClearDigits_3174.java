package com.wackstr.leetcode;

import java.util.ArrayDeque;

/*
2025-02-10
 */
public class ClearDigits_3174 {
    public String clearDigits(String s){
        ArrayDeque<Character> chars = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                chars.pollLast();
            }else{
                chars.add(c);
            }
        }
        StringBuilder clearString = new StringBuilder();
        while(!chars.isEmpty()){
            clearString.append(chars.pollFirst());
        }
        return clearString.toString();
    }

    public static void main(String[] args) {
        String s = "ag3";
        ClearDigits_3174 sol = new ClearDigits_3174();
        System.out.println(sol.clearDigits(s));
    }
}
