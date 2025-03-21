package com.wackstr.leetcode.learn.array;

import java.util.Arrays;

public class MergeArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1;
        int index2 = n - 1;
        int currIndex = (m + n) - 1;
        while(index1 >= 0 || index2 >= 0){
            if(index1 >= 0 && index2 >= 0){
                if(nums1[index1] > nums2[index2]){
                    nums1[currIndex] = nums1[index1];
                    index1--;
                }else{
                    nums1[currIndex] = nums2[index2];
                    index2--;
                }
            }else if(index1 >= 0){
                nums1[currIndex] = nums1[index1];
                index1--;
            }else{
                nums1[currIndex] = nums2[index2];
                index2--;
            }
            currIndex--;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        MergeArray sol = new MergeArray();
        sol.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}
