package com.wackstr.leetcode.learn.array;

import java.util.Arrays;

public class DuplicateZeroes {
    public void duplicateZeros(int[] arr){
        int n = arr.length;
        int[] newArr = new int[n];
        int newIndex = 0;
        int oldIndex = 0;
        while(newIndex < n){
            newArr[newIndex] = arr[oldIndex];
            if(arr[oldIndex] == 0){
                newIndex++;
                if(newIndex < n){
                    newArr[newIndex] = 0;
                }
            }
            oldIndex++;
            newIndex++;
        }
        System.arraycopy(newArr, 0, arr, 0, n);
    }

    public static void main(String[] args) {
        int[] arr = {1,0,2,3,0,4,5,0};
        DuplicateZeroes sol = new DuplicateZeroes();
        sol.duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));
    }


}
