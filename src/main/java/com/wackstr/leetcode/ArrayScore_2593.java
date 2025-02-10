package com.wackstr.leetcode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/*
2024-12-13
 */
public class ArrayScore_2593 {

    public long findScore(int[] nums){
        long score = 0;
        PriorityQueue<int[]> queue =
                new PriorityQueue<>(
                        (a,b) ->
                                a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]
                );

        Set<Integer> markedIndexes = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            queue.add(new int[]{nums[i], i});
        }

        while(!queue.isEmpty()){
            int[] currItem = queue.poll();
            int currVal = currItem[0];
            int currIndex = currItem[1];

            if(!markedIndexes.contains(currIndex)){
                score += currVal;
                if(currIndex > 0){
                    markedIndexes.add(currIndex - 1);
                }
                if(currIndex < nums.length - 1){
                    markedIndexes.add(currIndex + 1);
                }
            }
        }
        return score;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 4, 5, 2};
        ArrayScore_2593 sol = new ArrayScore_2593();
        System.out.println(sol.findScore(nums));
    }
}
