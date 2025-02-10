package com.wackstr.leetcode;

import java.util.Arrays;

public class MaximumXorForQuery {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int[] xorArray = getXorArray(nums);
        mapToQuery(xorArray, maximumBit);
        reverseArray(xorArray);
        return xorArray;
    }

    private void reverseArray(int[] xorArray) {
        for(int i = 0; i < xorArray.length/2; i++){
            int hold = xorArray[i];
            xorArray[i] = xorArray[xorArray.length - i - 1];
            xorArray[xorArray.length - i - 1] = hold;
        }
    }

    private void mapToQuery(int[] xorArray, int maximumBit) {
        int mask = (1 << maximumBit) - 1;
        for(int i = 0; i < xorArray.length; i++){
            int num = xorArray[i];
            xorArray[i] = ~num & mask;
        }
    }

    private int[] getXorArray(int[] nums) {
        int[] newArray = new int[nums.length];
        newArray[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            newArray[i] = nums[i] ^ newArray[i-1];
        }
        return newArray;
    }

    public static void main(String[] args) {
        int[] input = {0,1,1,3};
        MaximumXorForQuery sol = new MaximumXorForQuery();
        System.out.println(Arrays.toString(sol.getMaximumXor(input, 2)));
    }
}
