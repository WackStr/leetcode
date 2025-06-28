package com.wackstr.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
2025-06-28
 */
public class LargestSumSubsequence_2099 {
    public int[] maxSubsequence(int[] nums, int k){
        PriorityQueue<int[]> queue =
                new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for(int i = 0; i < nums.length; i++){
            if(queue.size() < k) queue.offer(new int[]{nums[i], i});
            else if(nums[i] > queue.peek()[0]){
                queue.poll();
                queue.offer(new int[]{nums[i], i});
            }
        }

        return queue.stream()
                .sorted(Comparator.comparingInt(a -> a[1]))
                .mapToInt(a -> a[0]).toArray();
    }

    public static void main(String[] args) {
        int[] nums = {-1,-2,3,4};
        int k =  3;
        LargestSumSubsequence_2099 sol = new LargestSumSubsequence_2099();
        System.out.println(Arrays.toString(sol.maxSubsequence(nums, k)));
    }
}
