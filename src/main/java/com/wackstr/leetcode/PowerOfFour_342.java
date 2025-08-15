package com.wackstr.leetcode;

/*
2025-08-15
 */
public class PowerOfFour_342 {
    public boolean isPowerOfFour(int s){
        if(s < 1) return false;
        while(s > 1){
            if(s % 4 != 0) return false;
            s /= 4;
        }
        return true;
    }
}
