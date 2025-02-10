package com.wackstr.leetcode;

/*
2024-12-4
 */
public class StringSubsequence_2825 {
    public boolean canMakeSubsequence(String str1, String str2){
        int pointer = 0;
        for(int i = 0; i < str2.length(); i++){
            char currChar = str2.charAt(i);
            boolean matched = false;
            while(pointer < str1.length()){
                char refChar = str1.charAt(pointer);
                pointer++;
                if(refChar == currChar ||
                        getIncrementedChar(refChar) == currChar)
                {
                    matched = true;
                    break;
                }
            }
            if(!matched) return false;
        }

        return true;
    }

    private char getIncrementedChar(char refChar) {
        char newChar = (char) (refChar + 1);
        return newChar > 'z' ? 'a' : newChar;
    }

    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "ad";
        StringSubsequence_2825 sol = new StringSubsequence_2825();
        System.out.println(sol.canMakeSubsequence(str1, str2));
    }
}
