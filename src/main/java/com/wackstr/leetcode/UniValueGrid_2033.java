package com.wackstr.leetcode;

import java.util.Arrays;

/*
2025-03-26
 */
public class UniValueGrid_2033 {

    public int minOperations(int[][] grid, int x) {
        // Create a list to store all the numbers from the grid
        int[] numsArray = new int[grid.length * grid[0].length];
        int result = 0;

        // Flatten the grid into numsArray
        for (int row = 0; row < grid.length; row++) {
            System.arraycopy(grid[row], 0, numsArray, row * grid[0].length, grid[0].length);
        }

        // Sort numsArray in non-decreasing order to easily find the median
        Arrays.sort(numsArray);

        int length = numsArray.length;
        // Store the median element as the final common value
        int finalCommonNumber = numsArray[length / 2];

        // Iterate through each number in numsArray
        for (int number : numsArray) {
            // If the remainder when divided by x is different, return -1
            if (number % x != finalCommonNumber % x) {
                return -1;
            }
            // Add the number of operations required to make the current number equal to finalCommonNumber
            result += Math.abs(finalCommonNumber - number) / x;
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] grid = {{141,105,69,273,681,105,933,417,309},{921,657,945,717,885,57,453,921,897},{681,345,657,177,897,609,465,801,429},{681,993,741,885,105,981,477,249,921},{369,885,945,537,45,861,381,345,417},{849,849,477,513,297,609,561,177,801},{561,417,129,585,621,561,261,153,501},{249,777,969,249,357,393,93,321,573},{525,813,381,909,825,297,681,345,813}};
        int x = 12;
        // expected 1632
        UniValueGrid_2033 sol = new UniValueGrid_2033();
        System.out.println(sol.minOperations(grid, x));
    }
}
