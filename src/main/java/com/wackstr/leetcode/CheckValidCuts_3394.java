package com.wackstr.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/*
2025-03-25
 */
public class CheckValidCuts_3394 {

    public boolean checkValidCuts(int n, int[][] rectangles){
        return canCut(rectangles, 0) || canCut(rectangles, 1);
    }

    public boolean canCut(
            int[][] rectangles, int dim){
        Arrays.sort(rectangles, Comparator.comparingInt(a -> a[dim]));
        int currEnd = rectangles[0][dim + 2];
        int gaps = 0;
        for(int i = 1; i < rectangles.length; i++) {
            int[] rec = rectangles[i];
            if(rec[dim] >= currEnd){
                gaps++;
            }
            currEnd = Math.max(currEnd, rec[dim + 2]);
        }
        return gaps >= 2;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] rectangles = {{1,0,5,2},{0,2,2,4},{3,2,5,3},{0,4,4,5}};
        CheckValidCuts_3394 sol = new CheckValidCuts_3394();
        System.out.println(sol.checkValidCuts(n, rectangles));
    }
}
