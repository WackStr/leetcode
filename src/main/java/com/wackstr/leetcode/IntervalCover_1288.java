package com.wackstr.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
2026-07-06 1288
 */
public class IntervalCover_1288 {
    public int removeCoveredIntervals(int[][] intervals){
        Arrays.sort(intervals, (a, b) ->
                a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]
        );

        int count = 0;
        int maxEnd = 0;

        for (int[] interval : intervals) {
            if (interval[1] > maxEnd) {
                count++;
                maxEnd = interval[1];
            }
        }

        return count;
    }

    private static int queueApproach(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0]-b[0]);
        Queue<Integer> indexes = new LinkedList<>();
        int res = 1;
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if(interval[0] < intervals[0][0] || interval[1] > intervals[0][1])
                indexes.offer(i);
        }
        while(!indexes.isEmpty()){
            int[] interval = intervals[indexes.poll()];
            res++;
            while(!indexes.isEmpty()){
                int[] target = intervals[indexes.peek()];
                if(target[0] < interval[0] || target[1] > interval[1]) break;
                indexes.poll();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,4}, {2,3}};
        IntervalCover_1288 sol = new IntervalCover_1288();
        System.out.println(sol.removeCoveredIntervals(intervals));
    }
}
