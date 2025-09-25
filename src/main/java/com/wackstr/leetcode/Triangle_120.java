package com.wackstr.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
2025-09-25
 */
public class Triangle_120 {
    public int minimumTotal(List<List<Integer>> triangle){
        List<Integer> currRow = triangle.get(triangle.size() - 1);
        for(int i = triangle.size() - 2; i >= 0; i--){
            List<Integer> nextRow = triangle.get(i);
            for(int j = 0; j < nextRow.size(); j++){
                nextRow.set(j, nextRow.get(j) + Math.min(currRow.get(j), currRow.get(j+1)));
            }
            currRow = nextRow;
        }
        return currRow.get(0);
    }

    public static void main(String[] args) {
        int[][] triangleData = {{2}, {3,4}, {6,5,7}, {4,1,8,3}};

        List<List<Integer>> triangle =
                Arrays.stream(triangleData).map(t -> {
                    ArrayList<Integer> list = new ArrayList<>();
                    for(int num : t) list.add(num);
                    return list;
                }).collect(Collectors.toList());
        Triangle_120 sol = new Triangle_120();
        System.out.println(sol.minimumTotal(triangle));
    }
}
