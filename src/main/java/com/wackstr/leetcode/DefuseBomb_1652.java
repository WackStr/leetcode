package com.wackstr.leetcode;

import java.util.Arrays;

/*
2024-11-18
 */
public class DefuseBomb_1652 {
    public int[] decrypt(int[] code, int k) {
        int n =  code.length;
        int[] ans = new int[n];
        if(k != 0){
            int startIndex = k > 0 ? 1 : n + k;
            int windowSize = k > 0 ? k : -k;
            int windowSum = 0;
            for(int i = 0; i < windowSize; i++){
                windowSum += code[(startIndex + i) % n];
            }
            ans[0] = windowSum;
            for(int i = 1; i < n; i++){
                windowSum -= code[startIndex % n];
                windowSum += code[(startIndex + windowSize)%n];
                startIndex++;
                ans[i] = windowSum;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] code = {5,7,1,4};
        int k = 3;
        DefuseBomb_1652 sol = new DefuseBomb_1652();
        System.out.println(Arrays.toString(sol.decrypt(code, k)));
    }
}
