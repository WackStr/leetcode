package com.wackstr.leetcode;

/*
2025-02-05
 */
public class StringSwapEquality_1790 {
    public boolean areAlmostEqual(String s1, String s2){
        int differences = 0;
        char c1 = 0, c2 = 0;
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                if(differences >= 2) return false;
                else if(differences == 0){
                    c1 = s1.charAt(i);
                    c2 = s2.charAt(i);
                }else if (differences == 1 && (c1 != s2.charAt(i) || c2 != s1.charAt(i))) return false;
                differences++;
            }
        }
        return differences == 0 || differences == 2;
    }

    public static void main(String[] args) {
        String s1 = "aa";
        String s2 = "ac";
        StringSwapEquality_1790 sol = new StringSwapEquality_1790();
        System.out.println(sol.areAlmostEqual(s1, s2));
    }
}
