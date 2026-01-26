package com.wackstr.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
2026-01-26 1200
 */
public class MinimumAbsoluteDifference_1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr){
        List<List<Integer>> res = new ArrayList<>();
        int minDistance = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            int currDistance = arr[i] - arr[i-1];
            if(currDistance < minDistance){
                res.clear();
                res.add(List.of(arr[i-1], arr[i]));
                minDistance = currDistance;
            }else if(currDistance == minDistance){
                res.add(List.of(arr[i-1], arr[i]));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {3,8,-10,23,19,-4,-14,27};
        MinimumAbsoluteDifference_1200 sol =
                new MinimumAbsoluteDifference_1200();
        System.out.println(sol.minimumAbsDifference(arr));
    }
}
