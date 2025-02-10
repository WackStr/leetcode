package com.wackstr.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
2024-12-16
 */
public class ArrayMultiplicationOperation_3264 {
    public int[] getFinalState(int[] nums, int k, int multiplier) {

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for(int i = 0; i < nums.length; i++){
            queue.add(new int[]{nums[i], i});
        }
        for(int i = 0; i < k; i++){
            int[] item = queue.poll();
            queue.add(new int[]{item[0] * multiplier, item[1]});
        }
        int[] finalState = new int[nums.length];
        for(int[] item : queue){
            finalState[item[1]] = item[0];
        }
        return finalState;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 1};
        int k = 1;
        int multiplier = 2;
        ArrayMultiplicationOperation_3264 sol = new ArrayMultiplicationOperation_3264();
        System.out.println(Arrays.toString(sol.getFinalState(nums, k, multiplier)));
    }
}
