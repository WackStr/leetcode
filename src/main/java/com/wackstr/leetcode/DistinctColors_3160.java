package com.wackstr.leetcode;

import java.util.*;

/*
2025-02-07
 */
public class DistinctColors_3160 {
    public int[] queryResults(int limit, int[][] queries){
        int[] queryAnswers = new int[queries.length];
        Map<Integer, Integer> colorToBalls = new HashMap<>();
        Map<Integer, Integer> ballToColor = new HashMap<>();
        for(int i = 0; i < queries.length; i++){
            int[] query = queries[i];
            int ball = query[0];
            int oldColor = ballToColor.getOrDefault(ball, 0);
            if(oldColor != 0){
                colorToBalls.put(oldColor, colorToBalls.get(oldColor) - 1);
                if(colorToBalls.get(oldColor) == 0){
                    colorToBalls.remove(oldColor);
                }
            }
            int newColor = query[1];
            colorToBalls.merge(newColor, 1, Integer::sum);
            queryAnswers[i] = colorToBalls.keySet().size();
            ballToColor.merge(ball, newColor, (a, b) -> b);
        }
        return queryAnswers;
    }

    public static void main(String[] args) {
        int limit = 1;
        int[][] queries = {{0,1},{0,4}, {0,4}, {0,1}, {1,2}};
        DistinctColors_3160 sol = new DistinctColors_3160();
        System.out.println(Arrays.toString(sol.queryResults(limit, queries)));
    }
}
