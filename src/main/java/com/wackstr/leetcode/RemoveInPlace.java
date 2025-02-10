package com.wackstr.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class RemoveInPlace {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        Deque<Integer> matchedIndex = new ArrayDeque<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == val){
                k++;
                matchedIndex.add(i);
            }else if(!matchedIndex.isEmpty()) {
                int replaceIndex = matchedIndex.pop();
                nums[replaceIndex] = nums[i];
                matchedIndex.add(i);
            }
        }
        return nums.length - k;
    }

    public static void main(String[] args) {
        int[] nums = {0,4,4,0,4,4,4,0,2};
        RemoveInPlace sol = new RemoveInPlace();
        System.out.println(sol.removeElement(nums, 4));
        System.out.println(Arrays.toString(nums));

    }
}
