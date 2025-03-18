package com.wackstr.leetcode.array_learn;

import java.util.ArrayList;
import java.util.List;

public class DisapperingNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> missingNums = new ArrayList<>();
        for(int num : nums){
            int index = Math.abs(num) - 1;
            nums[index] = -Math.abs(nums[index]);
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                missingNums.add(i + 1);
            }
        }
        return missingNums;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        DisapperingNumbers sol = new DisapperingNumbers();
        System.out.println(sol.findDisappearedNumbers(nums));
    }
}
