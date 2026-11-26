package com.wackstr.leetcode;

/*
2026-11-26 3360
 */
public class StoneRemovalGame_3360 {
    public boolean canAliceWin(int n){
        int[] ref = {10, 19, 27, 34, 40, 45, 49};
        int index = ref.length - 1;
        for (; index >= 0; index--) {
            if(n >= ref[index]) break;
        }
        return index % 2 == 0;
    }

    public static void main(String[] args) {
        int n = 2;
        StoneRemovalGame_3360 sol = new StoneRemovalGame_3360();
        System.out.println(sol.canAliceWin(n));
    }
}
