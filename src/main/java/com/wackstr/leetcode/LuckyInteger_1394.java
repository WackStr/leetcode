package com.wackstr.leetcode;

/*
2025-07-05
 */
public class LuckyInteger_1394 {
    public int findLucky(int[] arr){
        int[] cnt = new int[501];
        for(int num : arr) cnt[num]++;
        for(int i = cnt.length-1; i >= 1; i--)
            if(i == cnt[i]) return i;
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {7,7,7,7,7,7,7};
        LuckyInteger_1394 sol = new LuckyInteger_1394();
        System.out.println(sol.findLucky(arr));
    }
}
