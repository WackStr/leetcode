package com.wackstr.leetcode;

/*
2026-02-21 762
 */
public class PrimeSetBits_762 {
    public int countPrimeSetBits(int left, int right){
        int res = 0;
        for(int i = left; i  <= right; i++) {
            int cnt = Integer.bitCount(i);
            if(cnt == 2 || cnt == 3 || cnt == 5 || cnt == 7 || cnt == 11 ||
            cnt == 13 || cnt == 17 || cnt == 19 || cnt == 23 || cnt == 29 || cnt == 31){
                res++;
            }
        }
        return res;
    }



}
