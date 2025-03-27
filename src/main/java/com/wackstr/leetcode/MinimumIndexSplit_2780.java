package com.wackstr.leetcode;

import java.util.*;

/*
2025-03-27
 */
public class MinimumIndexSplit_2780 {
    public int minimumIndex(List<Integer> nums){
        int n = nums.size();
        Map<Integer, Integer> count = new HashMap<>();
        int dominantNumber = 0;
        int dominantCount = 0;
        int index = 0;
        for(; index < n; index++){
            int num = nums.get(index);
            count.merge(num, 1, Integer::sum);
            if(count.get(num) > n/2){
                dominantNumber = num;
                dominantCount = count.get(num);
                index++;
                break;
            }
        }

            while(index < n){
                int num = nums.get(index);
                if(num == dominantNumber) {
                    dominantCount++;
                }
                index++;
            }

        int currCount = 0;
        for(int i = 0; i < nums.size(); i++){
            int num = nums.get(i);
            if(num == dominantNumber) {
                currCount++;
            }

            boolean firstHalfDominant = currCount > (i+1)/2;
            boolean secondHalfDominant =
                    (dominantCount - currCount) > (n - i - 1)/2;
            if(firstHalfDominant && secondHalfDominant){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Integer[] nums = {3,3,3,3,7,2,2};
        MinimumIndexSplit_2780 sol = new MinimumIndexSplit_2780();
        System.out.println(sol.minimumIndex(Arrays.asList(nums)));
    }
}
