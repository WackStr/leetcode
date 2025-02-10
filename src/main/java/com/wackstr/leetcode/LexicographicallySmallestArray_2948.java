package com.wackstr.leetcode;

import java.util.*;

/*
2025-01-25
 */
public class LexicographicallySmallestArray_2948 {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        Map<Integer, Integer> numsToGroup = new HashMap<>();
        Map<Integer, Queue<Integer>> groupToList = new HashMap<>();

        int[] sortedNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortedNums);

        int group = -1;
        for(int i = 0; i < sortedNums.length; i++){
            int num = sortedNums[i];
            if(i == 0 || Math.abs(num - sortedNums[i-1]) > limit){
                group++;
                Queue<Integer> currList = new ArrayDeque<>();
                currList.add(num);
                groupToList.put(group, currList);
            }else{
                groupToList.get(group).add(num);
            }
            numsToGroup.put(num, group);
        }

        int[] finalArray = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            group = numsToGroup.get(num);
            finalArray[i] = groupToList.get(group).poll();
        }
        return finalArray;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 3, 9, 8};
        int limit = 2;
        LexicographicallySmallestArray_2948 sol =
                new LexicographicallySmallestArray_2948();
        System.out.println(
                Arrays.toString(
                        sol.lexicographicallySmallestArray(nums, limit)));
    }
}
