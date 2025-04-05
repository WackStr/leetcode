package com.wackstr.leetcode;

/*
2025-04-05
 */
public class SubsetXOR_1863 {
    public int subsetXORSum(int[] nums){
        return sum(nums[0], 1, nums) + sum(0, 1, nums);
    }

    public int sum(int curr, int index, int[] nums){
        if(index >= nums.length) return curr;
        int with = sum(curr ^ nums[index], index + 1, nums);
        int without = sum(curr, index + 1, nums);
        return with + without;
    }

    public int subsetXORSum_bitOperation(int[] nums) {
        int result = 0;
        // Capture each bit that is set in any of the elements
        for (int num : nums) {
            result |= num;
        }
        // Multiply by the number of subset XOR totals that will have each bit set
        return result << (nums.length - 1);
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 6, 7, 8};
        SubsetXOR_1863 sol = new SubsetXOR_1863();
        System.out.println(sol.subsetXORSum(nums));
    }
}
