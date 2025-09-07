package com.wackstr.leetcode;

/*
2025-09-07
 */
public class ZeroSum_1304 {
    public int[] sumZero(int n){
        int[] res = new int[n];
        int index = 0;
        if(n % 2 == 1) {
            res[index] = 0;
            index++;
        }
        int limit = n/2;
        for(int i = 1; i <= limit; i++){
            res[index] = i;
            res[index + 1] = -i;
            index += 2;
        }
        return res;
    }
}
