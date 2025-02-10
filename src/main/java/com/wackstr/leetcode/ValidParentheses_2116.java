package com.wackstr.leetcode;

/*
2025-01-12
 */
public class ValidParentheses_2116 {

    public boolean canBeValid(String s, String locked){
        int n = s.length();
        if((n & 1) == 1) return false;
        int openIndexes = 0;
        int lockedOpens = 0;
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            boolean isLocked = locked.charAt(i) == '1';
            if(isLocked){
                if(c == ')'){
                    if(lockedOpens > 0){
                        lockedOpens--;
                    }else if(openIndexes > 0){
                        openIndexes--;
                    }else{
                        return false;
                    }
                }
                if(c == '('){
                    lockedOpens++;
                }
            }else{
                openIndexes++;
            }
        }
        return ((openIndexes - lockedOpens) & 1) == 0;
    }

    public static void main(String[] args) {
        String s = "())((";
        String locked = "10001";
        ValidParentheses_2116 sol = new ValidParentheses_2116();
        System.out.println(sol.canBeValid(s, locked));
    }
}
