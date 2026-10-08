package com.wackstr.leetcode;

/*
2026-10-08 1021
 */
public class OutermostParentheses_1021 {
    public String removeOuterParentheses(String s) {
        int score = 0;
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        for (char c : arr) {
            if(score == 0){
                score++;
            }else{
                score += c == '(' ? 1 : -1;
                if(score > 0) sb.append(c);
            }
        }
        return sb.toString();
    }
}
