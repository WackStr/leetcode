package com.wackstr.leetcode;

import java.util.Arrays;

/*
2026-05-20 2657
 */
public class PrefixCommonArray_2657 {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] ans = new int[A.length];
        int[] freq = new int[A.length + 1];
        int common = 0;
        for(int i = 0; i < A.length; i++){
            freq[A[i]]++;
            if(freq[A[i]] == 2){
                common++;
            }
            freq[B[i]]++;
            if(freq[B[i]] == 2){
                common++;
            }
            ans[i] = common;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {2,3,1};
        int[] B = {3,1,2};
        PrefixCommonArray_2657 sol = new PrefixCommonArray_2657();
        System.out.println(Arrays.toString(sol.findThePrefixCommonArray(A,B)));
    }
}
