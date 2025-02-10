package com.wackstr.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumMovesForMountainArray {

    private static final int NOT_PROCESSED = -1;

    private record IndexItem(int index, int value){}

    public int minimumMountainRemovals(int[] nums) {
        Queue<IndexItem> queue = getMaximumNonTerminalPivot(nums);

        int runningMin = nums.length;
        Map<IndexItem, Integer> map = new HashMap<>();
        while(!queue.isEmpty()) {
            IndexItem pivot = queue.poll();
            if (pivot.index() > 0 && pivot.index() < nums.length - 1) {
                int left = getLeftSteps(nums, pivot.index());
                int right = getRightSteps(nums, pivot.index());
                if (left == 0 && right == 0) {
                    return 0;
                }
                if (left != pivot.index() && right != nums.length - pivot.index()) {
                    map.put(pivot, left + right);
//                    if (left + right < runningMin) {
//                        runningMin = left + right;
//                    }

                }
            }
        }
        return runningMin;
    }

    private Queue<IndexItem> getMaximumNonTerminalPivot(int[] nums) {
        PriorityQueue<IndexItem> queue = new PriorityQueue<>((a,b) -> b.value() - a.value());
        for(int i = 0; i < nums.length; i++){
            queue.add(new IndexItem(i, nums[i]));
        }
        return queue;
    }

    private int getLeftSteps(int[] nums, int i) {
        return aggLeft(nums, 0, i, 0, NOT_PROCESSED);
    }

    private int getRightSteps(int[] nums, int i) {
        return aggRight(nums, nums.length - 1, i, 0, NOT_PROCESSED);
    }

    private int aggLeft(int[] nums, int currIndex, int finalStop, int runningCount, int item){
        if(currIndex >= finalStop-1){
            return nums[currIndex] < nums[finalStop] && nums[currIndex] > item ? runningCount : runningCount + 1;
        }else{
            int with = NOT_PROCESSED;
            if((item == NOT_PROCESSED && nums[currIndex] < nums[finalStop]) || (nums[currIndex] > item && nums[currIndex] < nums[finalStop])){
                with = aggLeft(nums, currIndex + 1, finalStop, runningCount, nums[currIndex]);
            }
            int without = aggLeft(nums, currIndex + 1, finalStop, runningCount + 1, item);
            if (with == NOT_PROCESSED){
                return without;
            }else{
                return Math.min(with, without);
            }
        }
    }

    private int aggRight(int[] nums, int currIndex, int finalStop, int runningCount, int item){
        if(currIndex <= finalStop+1){
            return nums[currIndex] < nums[finalStop] && nums[currIndex] > item ? runningCount : runningCount + 1;
        }else{
            int with = NOT_PROCESSED;
            if((item == NOT_PROCESSED && nums[currIndex] < nums[finalStop]) || (nums[currIndex] > item && nums[currIndex] < nums[finalStop])){
                with = aggRight(nums, currIndex - 1, finalStop, runningCount, nums[currIndex]);
            }
            int without = aggRight(nums, currIndex - 1, finalStop, runningCount + 1, item);
            if (with == NOT_PROCESSED){
                return without;
            }else{
                return Math.min(with, without);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,9,19,45,41,96,72,40,100,37,36,13,7};
        MinimumMovesForMountainArray sol = new MinimumMovesForMountainArray();
        int steps = sol.minimumMountainRemovals(nums);
        System.out.println(steps);
    }
}
