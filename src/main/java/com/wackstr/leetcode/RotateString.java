package com.wackstr.leetcode;

public class RotateString {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()){
            return false;
        }else {
            return matchRotationForEqualStrings(s, goal);
        }
    }

    private static boolean matchRotationForEqualStrings(String s, String goal) {
        boolean matched = false;
        for (int i = 0; i < goal.length(); i++) {
            if(s.charAt(0) == goal.charAt(i)){
                matched = true;
                for(int j = 1; j < goal.length(); j++){
                    int charIndex = (i + j) % goal.length();
                    if(s.charAt(j) != goal.charAt(charIndex)){
                        matched = false;
                        break;
                    }
                }
                if(matched){
                    break;
                }
            }
        }
        return matched;
    }

    public static void main(String[] args) {
        String s = "abcde";
        String goal = "abced"; // abced
        RotateString sol = new RotateString();
        System.out.println(sol.rotateString(s, goal));

    }
}
