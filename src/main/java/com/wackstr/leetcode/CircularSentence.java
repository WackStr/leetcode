package com.wackstr.leetcode;

public class CircularSentence {

    public boolean isCircularSentence(String sentence) {
        String[] splits = sentence.split(" ");

        boolean isCircular = true;

        for (int i = 0; i < splits.length - 1; i++) {
            char lastChar = splits[i].charAt(splits[i].length() - 1);
            char firstChar = splits[i+1].charAt(0);
            if(lastChar != firstChar){
                isCircular = false;
                break;
            }
        }
        String lastWord = splits[splits.length - 1];
        String firstWord = splits[0];
        isCircular = isCircular &&
                firstWord.charAt(0) == lastWord.charAt(lastWord.length() - 1);
        return isCircular;
    }

    public static void main(String[] args) {
        String in = "leetcode";
        CircularSentence sol = new CircularSentence();
        System.out.println(sol.isCircularSentence(in));
    }
}
