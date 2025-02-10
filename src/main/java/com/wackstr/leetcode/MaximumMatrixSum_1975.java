package com.wackstr.leetcode;

/*
2024-11-24
 */
public class MaximumMatrixSum_1975 {
    public long maxMatrixSum(int[][] matrix) {
        long maxSum = 0;
        int minNum = -1;
        boolean oddNegatives = false;
        for(int[] row: matrix){
            for(int cell: row){
                int absVal = Math.abs(cell);
                if(cell < 0){
                    oddNegatives ^= true;
                }
                maxSum += absVal;
                if(minNum == -1 || absVal < minNum){
                    minNum = absVal;
                }
            }
        }
        return maxSum - (oddNegatives ? 2L * minNum : 0);
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{-1,-2,-3},{1,2,3}};
        MaximumMatrixSum_1975 sol = new MaximumMatrixSum_1975();
        System.out.println(sol.maxMatrixSum(matrix));
    }
}
