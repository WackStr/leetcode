package com.wackstr.leetcode;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class MaximumPassRatio_1792 {

    public double maxAverageRatio(int[][] classes, int extraStudents) {
//        Arrays.sort(classes,
//                (a,b) ->
//                        a[1] * (a[1] + extraStudents) * (b[1] - b[0]) -
//                                b[1] * (b[1] + extraStudents) * (a[1] - a[0])
//                );
//        double maxAverage = 0;
//        maxAverage += (1.0*(classes[0][0] + extraStudents))/(classes[0][1] + extraStudents);
//        for(int i = 1; i < classes.length; i++){
//            int[] cls = classes[i];
//            maxAverage += (1.0*cls[0])/cls[1];
//        }
//        maxAverage /= classes.length;
//        return maxAverage;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) ->
                a[1] * (a[1] + 1) * (b[1] - b[0]) -
                b[1] * (b[1] + 1) * (a[1] - a[0]));
        Collections.addAll(queue, classes);
        while(extraStudents > 0){
            int[] cls = queue.poll();
            queue.add(new int[]{cls[0] + 1, cls[1] + 1});
            extraStudents--;
        }
        double maxAverage = 0;
        while(!queue.isEmpty()){
            int[] cls = queue.poll();
            maxAverage += (1.0*cls[0])/cls[1];
        }
        maxAverage /= classes.length;
        return maxAverage;
    }

    public static void main(String[] args) {
        int[][] classes = {{1,2}, {3, 5}, {2,2}};
        int extraStudents = 2;
        MaximumPassRatio_1792 sol = new MaximumPassRatio_1792();
        System.out.println(sol.maxAverageRatio(classes, extraStudents));
    }
}
