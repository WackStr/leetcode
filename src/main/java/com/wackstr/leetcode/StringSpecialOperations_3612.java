package com.wackstr.leetcode;

/*
2026-06-16 3612
 */
public class StringSpecialOperations_3612 {
    public String processStr(String s) {
        StringBuilder str = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '#'){
                str.append(str.toString());
            }else if(ch == '%'){
                str.reverse();
            }else if(ch == '*'){
                if(str.length() > 0){
                    str.deleteCharAt(str.length() - 1);
                }
            }else{
                str.append(ch);
            }
        }
        return str.toString();

    }

    public static void main(String[] args) {
        String s = "*#g";
        StringSpecialOperations_3612 sol = new StringSpecialOperations_3612();
        System.out.println(sol.processStr(s));
    }
}
