package com.wackstr.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class MaxKElements {

    public long maxKelementsIter(int[] nums, int k){
        long score = 0;
        for(int i = 0; i < k; i++){
            int maxIndex = 0;
            int maxVal = nums[maxIndex];
            for(int j = 1; j < nums.length; j++){
                if(nums[j] > maxVal){
                    maxIndex = j;
                    maxVal = nums[j];
                }
            }
            score += nums[maxIndex];

            int val1 = nums[maxIndex]/3;
            int val2 = nums[maxIndex] % 3;
            if(val2 != 0){
                val1 += 1;
            }
            nums[maxIndex] = val1;
        }
        return score;
    }

    public long maxKelementsSort(int[] nums, int k){
        PriorityQueue<Integer> queue =
                new PriorityQueue<>(Collections.reverseOrder());
        long score = 0;
        for(int i = 0; i < nums.length; i++){
            queue.add(nums[i]);
        }

        for(int i = 0; i < k; i++){
            int maxVal= queue.poll();
            score += maxVal;

            int val1 = maxVal/3;
            int val2 = maxVal % 3;
            if(val2 > 0){
                val1 += 1;
            }
            queue.add(val1);
        }
        return score;
    }

    public long maxKelements(int[] nums, int k){
        return maxKelementsSort(nums, k);
    }

    public static void main(String[] args) {
        int[] nums = {10,10,10,10,10};
        MaxKElements sol = new MaxKElements();
        System.out.println(sol.maxKelements(nums, 3));
    }
}
