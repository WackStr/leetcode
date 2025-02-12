package com.wackstr.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
2025-02-12
 */
public class MaximumPairSum_2342 {

    private static class DigitSum {
        PriorityQueue<Integer> queue;

        public DigitSum(){
            this.queue = new PriorityQueue<>();
        }

        public int add(int num){
            queue.add(num);
            if(queue.size() <= 1) return -1;
            while(queue.size() > 2){
                queue.poll();
            }
            int num1 = queue.poll();
            int num2 = queue.poll();
            int sum = num1 + num2;
            queue.add(num1);
            queue.add(num2);
            return sum;
        }

    }

    public int maximumSum(int[] nums){
        Map<Integer, DigitSum> digitSums = new HashMap<>();
        int max = -1;
        for(int num : nums){
            int digitSum = getDigitSum(num);
            int currMax =
                    digitSums.computeIfAbsent(digitSum, k -> new DigitSum()).add(num);
            max = Math.max(max, currMax);
        }
        return max;
    }

    private int getDigitSum(int num) {
        int sum = 0;
        while(num > 0){
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {229,398,269,317,420,464,491,218,439,153,482,169,411,93,147,50,347,210,251,366,401};
        MaximumPairSum_2342 sol = new MaximumPairSum_2342();
        System.out.println(sol.maximumSum(nums));
    }
}
