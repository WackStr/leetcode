package com.wackstr.leetcode;

import java.util.Arrays;

/*
2025-05-17
 */
public class SortColors_75 {
    public void sortColors(int[] nums){
        int[] color = new int[3];
        for(int num : nums){
            if(num == 0) color[0]++;
            else if(num == 1) color[1]++;
            else color[2]++;
        }
        int i = 0;
        while(i < color[0]) nums[i++] = 0;
        int k = color[0] + color[1];
        while(i < k) nums[i++] = 1;
        while(i < nums.length) nums[i++] = 2;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        SortColors_75 sol = new SortColors_75();
        sol.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
