package com.wackstr.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
2026-05-14
 */
public class GoodArray_2784 {
    public boolean isGood(int[] nums) {
        int n = nums.length - 1;
        int maxCount = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if(num > n) return false;
            else if(num == n){
                maxCount++;
                if(maxCount > 2) return false;
            }else{
                if(set.contains(num)) return false;
                set.add(num);
            }
        }
        return maxCount==2 && set.size() == (n-1);
    }

    private static int[] baseArray(int n){
        int[] arr = new int[n+1];
        for (int i = 0; i < n; i++) {
            arr[i] = i+1;
        }
        arr[arr.length - 2] = n;
        arr[arr.length - 1] = n;
        return arr;
    }

    public static void main(String[] args) {
        GoodArray_2784 sol = new GoodArray_2784();
        int[] nums = {2, 1, 3};
        System.out.println(sol.isGood(nums));
    }
}
