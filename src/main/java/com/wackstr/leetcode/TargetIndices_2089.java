package com.wackstr.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
2026-10-19 2089
 */
public class TargetIndices_2089 {
    public List<Integer> targetIndices(int[] nums, int target) {
        int lessThanTargetCount = 0;
        int targetCount = 0;
        for (int num : nums) {
            if (num < target) {
                lessThanTargetCount++;
            } else if (num == target) {
                targetCount++;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < targetCount; i++) {
            result.add(lessThanTargetCount + i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,5,2,3};
        int target = 2;
        TargetIndices_2089 sol = new TargetIndices_2089();
        System.out.println(sol.targetIndices(nums,target));
    }
}
