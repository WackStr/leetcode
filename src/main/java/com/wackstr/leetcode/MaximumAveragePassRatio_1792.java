package com.wackstr.leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

/*
2025-09-01
 */
public class MaximumAveragePassRatio_1792 {
    private static double getMetric(int[] c){
        return (c[1] - c[0]) / (1.0 * c[1] * (c[1] + 1));
    }
    public double maxAverageRatio(int[][] classes, int extraStudents){
        PriorityQueue<int[]> queue = new PriorityQueue<>(
                (a,b) -> Double.compare(getMetric(b), getMetric(a)));
        Collections.addAll(queue, classes);
        while(extraStudents > 0){
            int[] currClass = queue.poll();
            queue.offer(new int[]{currClass[0] + 1, currClass[1] + 1});
            extraStudents--;
        }
        double avg = 0;
        for(int[] currClass : queue){
            avg += currClass[0] * 1.0 / currClass[1];
        }
        int denominator = classes.length;
        return avg/denominator;
    }

    public static void main(String[] args) {
        int[][] classes = {{1,2}, {3,5}, {2,2}};
        int extraStudents = 2;
        MaximumAveragePassRatio_1792 sol = new MaximumAveragePassRatio_1792();
        System.out.println(sol.maxAverageRatio(classes, extraStudents));
    }
}
