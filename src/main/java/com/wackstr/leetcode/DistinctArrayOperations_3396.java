package com.wackstr.leetcode;

/*
2025-04-08
 */
public class DistinctArrayOperations_3396 {
    public int minimumOperations(int[] nums) {
        int k = nums.length - 1;
        /*
        Track count of each element encountered
        no need to create a Map<Integer, Integer> can use an array because
        of constraint (1 <= nums[i] <= 100)
         */
        boolean[] lookup = new boolean[101];
        while(k >= 0){
            /*
            if we encounter duplication at index k as we move right to left,
            we have to remove k + 1 elements from left
            the number of 3-span operations needed are
            ( (k + 1) + (3 - 1) ) / 3 = (k + 3)/3
            added (3 - 1) = 2 to round up the integer operation
             */
            if(lookup[nums[k]]) return (k+3)/3;
            lookup[nums[k]] = true;
            k--;
        }
        // no duplicates found, return 0
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {5,5};
        DistinctArrayOperations_3396 sol = new DistinctArrayOperations_3396();
        System.out.println(sol.minimumOperations(nums));
    }
}
