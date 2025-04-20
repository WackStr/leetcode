package com.wackstr.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
2025-04-20
 */
public class RabbitsInForest_781 {
    public int numRabbits(int[] answers){
        Map<Integer, Integer> counts = new HashMap<>();
        for(int answer : answers){
            counts.merge(answer, 1, Integer::sum);
        }
        int min = 0;
        for(Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            int answer = entry.getKey();
            int count = entry.getValue();
            min += ((count + answer)/(answer + 1))*(answer + 1);
        }
        return min;
    }

    public static void main(String[] args) {
        int[] answers = {10, 10, 10};
        RabbitsInForest_781 sol = new RabbitsInForest_781();
        System.out.println(sol.numRabbits(answers));
    }
}
