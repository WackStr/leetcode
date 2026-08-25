package com.wackstr.leetcode;

/*
2026-08-25 3718
 */
public class MissingMultiple_3718 {
    private static final int N = 100;

    public int missingMultiple(int[] nums, int k) {
        boolean[] map = new boolean[N+1];
        for (int num : nums) map[num] = true;
        for (int i = 1; i < N; i++) {
            int index = i * k;
            if(index > N || !map[index]) return index;
        }
        return N+1;
    }

    public static void main(String[] args) {
        int[] nums = new int[100];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }
        int k  = 1;
        MissingMultiple_3718 sol = new MissingMultiple_3718();
        System.out.println(sol.missingMultiple(nums, k));
    }
}
