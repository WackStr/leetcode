package com.wackstr.leetcode;

/*
2024-12-3
 */
public class AddSpaces_2109 {
    public String addSpaces(String s, int[] spaces) {
        int spaceCount = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length() + spaces.length; i++){
            if(spaceCount < spaces.length && spaces[spaceCount] == i - spaceCount){
                sb.append(' ');
                spaceCount++;
            }else{
                sb.append(s.charAt(i - spaceCount));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "LeetcodeHelpsMeLearn";
        int[] spaces = {8, 13, 15};
        AddSpaces_2109 sol = new AddSpaces_2109();
        System.out.println(sol.addSpaces(s, spaces));
    }
}
