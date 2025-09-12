package com.wackstr.leetcode;

import java.util.Set;

/*
2025-09-12
 */
public class VowelGame_3227 {
    public boolean doesAliceWin(String s) {
        for(int i=0;i<s.length();i++){
            int ch=s.charAt(i);
            if(ch=='a' || ch=='e' ||ch=='i' ||ch=='o' ||ch=='u') return true;

        } return false;
    }
}
