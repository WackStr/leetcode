package com.wackstr.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/*
2025-04-26
 */
public class FixedBoundArray_2444 {
    // sliding window
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long count = 0;
        int start = -1, mini = -1, maxi = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minK || nums[i] > maxK) start = i;
            if (nums[i] == maxK) maxi = i;
            if (nums[i] == minK) mini = i;
            int valid = Math.max(0, Math.min(mini, maxi) - start);
            count += valid;
        }
        return count;
    }

    // monotonic queue
    public long countSubarraysQueue(int[] nums, int minK, int maxK) {
        long count = 0;
        int left = 0;
        Deque<Integer> dq_min = new ArrayDeque<>();
        Deque<Integer> dq_max = new ArrayDeque<>();

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] < minK || nums[i] > maxK) {
                dq_min.clear();
                dq_max.clear();
                left = i + 1;
                continue;
            }
            while (!dq_min.isEmpty() && nums[dq_min.peekLast()] >= nums[i]) dq_min.pollLast();
            dq_min.offerLast(i);
            while (!dq_max.isEmpty() && nums[dq_max.peekLast()] <= nums[i]) dq_max.pollLast();
            dq_max.offerLast(i);
            if (nums[dq_min.peekFirst()] == minK && nums[dq_max.peekFirst()] == maxK) {
                int start = Math.min(dq_min.peekFirst(), dq_max.peekFirst());
                count += (start - left + 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,2,7,5};
        int minK = 1;
        int maxK = 5;

        FixedBoundArray_2444 sol = new FixedBoundArray_2444();
        System.out.println(sol.countSubarrays(nums, minK, maxK));
        System.out.println(sol.countSubarraysQueue(nums, minK, maxK));
    }
}
