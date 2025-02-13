package com.wackstr.leetcode;

import java.util.PriorityQueue;

/*
2025-02-13
 */
public class MinimumOperations_3066 {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> queue = new PriorityQueue<>();
        for(int num : nums){
            queue.add((long) num);
        }
        int operationCount = 0;
        while(queue.size() >= 2 && queue.peek() < k ){
            long num1 = queue.poll();
            long num2 = queue.poll();
            queue.add(Math.min(num1, num2) * 2 + Math.max(num1, num2));
            operationCount++;
        }
        return operationCount;
    }

    public static void main(String[] args) {
        int[] nums = {1000000000,999999999,1000000000,999999999,1000000000,999999999};
        int k = 1000000000;
        MinimumOperations_3066 sol = new MinimumOperations_3066();
        System.out.println(sol.minOperations(nums, k));
    }
}
