package com.wackstr.leetcode;

/*
2026-02-18 693
 */
public class BinaryNumber_693 {
    public boolean hasAlternatingBits(int n){
        int curr = n & 1;
        n >>>= 1;
        while(n > 0){
            int next = n & 1;
            if((next ^ curr) != 1) return false;
            curr = next;
            n >>>= 1;
        }
        return true;
    }
}
