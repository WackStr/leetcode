package com.wackstr.leetcode.learn.array;

import java.util.Arrays;

public class ReplaceElements {
    public int[] replaceElements(int[] arr){
        int max = arr[arr.length - 1];
        for(int i = arr.length - 2; i >= 0; i--){
            int temp = arr[i];
            arr[i] = max;
            max = Math.max(temp, arr[i]);
        }
        arr[arr.length - 1] = -1;
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {17,18,5,4,6,1};
        ReplaceElements sol = new ReplaceElements();
        System.out.println(Arrays.toString(sol.replaceElements(arr)));
    }
}
