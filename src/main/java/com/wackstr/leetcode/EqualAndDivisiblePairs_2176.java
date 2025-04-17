package com.wackstr.leetcode;

/*
2025-04-17
 */
public class EqualAndDivisiblePairs_2176 {
    public int countPairs(int[] nums, int k){
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if((i*j)%k == 0 && nums[i] == nums[j]) res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 2, 2, 1, 3};
        int k = 2;
        EqualAndDivisiblePairs_2176 sol = new EqualAndDivisiblePairs_2176();
        System.out.println(sol.countPairs(nums, k));
    }
}
