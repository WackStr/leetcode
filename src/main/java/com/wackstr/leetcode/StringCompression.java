package com.wackstr.leetcode;

/*
2024-11-04: String compression III
3163
 */
public class StringCompression {

    private static final int MAX_MATCH_LENGTH = 9;

    public String compressedString(String word) {
        StringBuilder ans = new StringBuilder();
        int i = 0;
        while(i < word.length()){
            char c = word.charAt(i);
            int j = i+1;
            for(; j < word.length() && j - i < MAX_MATCH_LENGTH; j++){
                if(word.charAt(j) != c){
                    break;
                }
            }
            ans.append(j-i);
            ans.append(c);
            i = j;
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String input = "abcde";
        StringCompression sol = new StringCompression();
        System.out.println(sol.compressedString(input));
    }
}
