package com.wackstr.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
2025-03-06
 */
public class MissingAndRepeated_2965 {
    public int[] findMissingAndRepeatedValues(int[][] grid){
        int n = grid[0].length * grid.length + 1;
        Map<Integer, Integer> lookup = new HashMap<>();
        int repeated = 0;
        int missing = 0;
        for(int[] row : grid){
            for(int num : row){
                if(lookup.containsKey(num)){
                    repeated = num;
                    lookup.put(num, 2);
                }else{
                    lookup.put(num, 1);
                }
            }
        }
        for(int i = 1; i < n; i++){
            if(!lookup.containsKey(i)){
                missing = i;
                break;
            }
        }
        return new int[]{repeated, missing};
    }

    public int[] findMissingAndRepeatedValues_algebra(int[][] grid) {
        long sum = 0, sqrSum = 0;
        long n = grid.length;
        long total = n * n;

        // Calculate actual sum and squared sum from grid
        for (int row = 0; row < n; ++row) {
            for (int col = 0; col < n; ++col) {
                sum += grid[row][col];
                sqrSum += (long) grid[row][col] * grid[row][col];
            }
        }

        // Calculate differences from expected sums
        // Expected sum: n(n+1)/2, Expected square sum: n(n+1)(2n+1)/6
        long sumDiff = sum - (total * (total + 1)) / 2;
        long sqrDiff = sqrSum - (total * (total + 1) * (2 * total + 1)) / 6;

        // Using math: If x is repeated and y is missing
        // sumDiff = x - y
        // sqrDiff = x² - y²
        int repeat = (int) (sqrDiff / sumDiff + sumDiff) / 2;
        int missing = (int) (sqrDiff / sumDiff - sumDiff) / 2;

        return new int[] { repeat, missing };
    }

    public static void main(String[] args) {
        int[][] grid = {{1,3}, {2,2}};
        MissingAndRepeated_2965 sol = new MissingAndRepeated_2965();
        System.out.println(
                Arrays.toString(sol.findMissingAndRepeatedValues(grid)));
    }
}
