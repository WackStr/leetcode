package com.wackstr.leetcode;

/*
2024-12-2
 */
public class CheckWordPrefix_1455 {
    public int isPrefixOfWord(String sentence, String searchWord){
        String[] parts = sentence.split(" ");
        for(int i = 0; i < parts.length; i++){
            String part = parts[i];
            if(part.startsWith(searchWord)){
                return i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String sentence = "i love eating burger";
        String searchWord = "burg";

        CheckWordPrefix_1455 sol = new CheckWordPrefix_1455();
        System.out.println(sol.isPrefixOfWord(sentence, searchWord));
    }
}
