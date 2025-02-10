package com.wackstr.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
2025-01-14
 */
public class CommonPrefixArray_2657{
    public int[] findThePrefixCommonArray(int[] A, int[] B){
        int[] prefix = new int[A.length];
        Set<Integer> commonSet = new HashSet<>();
        int commonCount = 0;
        for(int i = 0; i < A.length; i++){
            int iA = A[i], iB = B[i];
            if(commonSet.contains(iA)) commonCount++;
            commonSet.add(iA);
            if(commonSet.contains(iB)) commonCount++;
            commonSet.add(iB);
            prefix[i] = commonCount;
        }
        return prefix;
    }

    public static void main(String[] args) {
        int[] A = {1, 3, 2, 4};
        int[] B = {3, 1, 2, 4};
        CommonPrefixArray_2657 sol = new CommonPrefixArray_2657();
        System.out.println(Arrays.toString(sol.findThePrefixCommonArray(A, B)));
    }
}
