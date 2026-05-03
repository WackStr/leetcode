package com.wackstr.leetcode;

/*
2026-05-03 796
 */
public class RotateString_796 {
    public boolean rotateString(String s, String goal){
        if(s.length() != goal.length()) return false;
        char[] sArr = s.toCharArray();
        char[] goalArr = goal.toCharArray();
        for(int i = 0; i < sArr.length; i++) {
            if (sArr[i] == goalArr[0] && canRotate(i, sArr, goalArr)) {
                return true;
            }
        }
        return false;
    }

    private boolean canRotate(int startIndex, char[] sArr, char[] goalArr) {
        int n = sArr.length;
        for(int i = startIndex; i < n + startIndex; i++) {
            if (sArr[i % n] != goalArr[i - startIndex]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abcde";
        String goal = "abced";
        RotateString_796 sol = new RotateString_796();
        System.out.println(sol.rotateString(s, goal));
    }
}
