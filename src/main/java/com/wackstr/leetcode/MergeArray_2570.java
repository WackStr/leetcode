package com.wackstr.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
2025-02-03
 */
public class MergeArray_2570 {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2){
        int left = 0, right = 0;
        List<int[]> mergedArray = new ArrayList<>();
        while(left < nums1.length && right < nums2.length){
            if(nums1[left][0] < nums2[right][0]){
                mergedArray.add(new int[]{nums1[left][0], nums1[left][1]});
                left++;
            }else if(nums1[left][0] > nums2[right][0]){
                mergedArray.add(new int[]{nums2[right][0], nums2[right][1]});
                right++;
            }else{
                mergedArray.add(new int[]{nums1[left][0], nums1[left][1] + nums2[right][1]});
                left++;
                right++;
            }
        }
        while(left < nums1.length) {
            mergedArray.add(new int[]{nums1[left][0], nums1[left][1]});
            left++;
        }
        while(right < nums2.length){
            mergedArray.add(new int[]{nums2[right][0], nums2[right][1]});
            right++;
        }
        return mergedArray.toArray(new int[mergedArray.size()][2]);
    }

    public static void main(String[] args) {
        int[][] nums1 = {{1,2}, {2,3}, {4,5}}, nums2 = {{1,4}, {3,2}, {4,1}};
        MergeArray_2570 sol = new MergeArray_2570();
        System.out.println(Arrays.deepToString(sol.mergeArrays(nums1, nums2)));

    }
}
