package com.wackstr.leetcode.array_learn;

public class MountainArray {

    public boolean validMountainArray(int[] arr) {
        if(arr.length < 3) return false;
        if(arr[1] < arr[0] || arr[arr.length-1] > arr[arr.length-2]) return false;
        int i = 0;
        while(i < arr.length - 1 && arr[i] < arr[i+1]) i++;
        if(arr[i] == arr[i+1]) return false;
        while(i < arr.length - 1 && arr[i] > arr[i+1]) i++;
        return i == arr.length - 1;
    }

    public static void main(String[] args) {
        int[] arr = {0, 3, 2, 1};
        MountainArray sol = new MountainArray();
        System.out.println(sol.validMountainArray(arr));
    }
}
