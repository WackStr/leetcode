package com.wackstr.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/*
2044. Count number of Maximum  Bitwise-OR Subsets

 */
public class MaximumBitwiseOrSubsets {

    public int countMaxOrSubsets(int[] nums){
        int max = getMaxOr(nums);
        int cnt = 0;
        int[][] powersets = getPowerset(nums);
        for(int[] subset: powersets){
            int currMax = getMaxOr(subset);
            if(currMax == max){
                cnt++;
            }
        }
        return cnt;
    }

    private int[][] getPowerset(int[] nums) {
        if(nums.length == 0){
            return new int[][]{};
        }else if (nums.length == 1){
            return new int[][]{{nums[0]}, {}};
        }else{
            return mergeForPowerSet(nums[0], getPowerset(Arrays.stream(nums).skip(1).toArray()));
        }
    }

    private int[][] mergeForPowerSet(int num, int[][] powerset) {
        List<int[]> ans =
        new ArrayList<>(Arrays.stream(powerset).map(t -> {
            int[] addedArray = new int[t.length+1];
            System.arraycopy(t, 0, addedArray, 0, t.length);
            addedArray[addedArray.length-1] = num;
            return addedArray;
        }).toList());
        Collections.addAll(ans, powerset);
        return ans.toArray(new int[ans.size()][]);
    }

    public int getMaxOr(int[] nums){
        if(nums.length > 0) {
            // get the maximum number
            int max = nums[0];
            for (int i = 1; i < nums.length; i++) {
                max |= nums[i];
            }
            return max;
        }else{
            return 0;
        }
    }

    public static void main(String[] args) {
        MaximumBitwiseOrSubsets sol = new MaximumBitwiseOrSubsets();
        int[] test = {3, 1};
        System.out.println(sol.countMaxOrSubsets(test));
    }
}
