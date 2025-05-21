package com.wackstr.leetcode.learn.HashMap;

import java.util.*;

public class TopKFrequency {
    /*
    Given an integer array nums and an integer k, return the k most frequent
    elements. You may return the answer in any order.
     */
    public int[] topKFrequent(int[] nums, int k){
        Map<Integer, Integer> cnt = new HashMap<>();
        for(int num : nums){
            cnt.merge(num, 1, Integer::sum);
        }
        Queue<Map.Entry<Integer, Integer>> queue =
                new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for(Map.Entry<Integer, Integer> entry : cnt.entrySet()){
            if(queue.size() < k){
                queue.add(entry);
            }else if(queue.peek().getValue() < entry.getValue()){
                queue.poll();
                queue.add(entry);
            }
        }
        int[] res = new int[k];
        int i = 0;
        for(Map.Entry<Integer, Integer> entry : queue){
            res[i++] = entry.getKey();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        int k = 1;
        TopKFrequency sol = new TopKFrequency();
        System.out.println(Arrays.toString(sol.topKFrequent(nums, k)));
    }
}
