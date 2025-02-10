package com.wackstr.leetcode;

import java.util.Arrays;

/*
2024-12-1
 */
public class CheckForDoubleInArray_1346 {

    // putting in a set for comparison is faster
    // space is not O(1) since sorting takes up space O(n) or O(log n)!!
    public boolean checkIfExist(int[] arr){
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++){
            int j = -1;
            if(arr[i] != 0) {
                j = Arrays.binarySearch(arr, 2 * arr[i]);
            }else{
                if(i > 0 && arr[i-1] == 0){
                        return true;
                }else if(i < arr.length - 1 && arr[i+1] == 0){
                    return true;
                }
            }
            if(j >= 0){
                return true;
            }
        }
        return false;
    }

    private int find(int[] arr, int target, int left, int right) {
        while(left <= right){
            int mid = (left + right) / 2;
            if(arr[mid] == 2) return mid;
            else if(arr[mid] > target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {10, 2, 5, 3};
        CheckForDoubleInArray_1346 sol = new CheckForDoubleInArray_1346();
        System.out.println(sol.checkIfExist(arr));
    }
}
