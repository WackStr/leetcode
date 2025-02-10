package com.wackstr.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/*
2024-11-22
 */
public class FlipColumns_1072 {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int maxCount = 1;
        Deque<Integer> indexes = new ArrayDeque<>();
        for(int i = 0; i < matrix.length; i++){
            indexes.add(i);
        }
        while (!indexes.isEmpty()){
            int tmpCnt = 1;
            int[] currRow = matrix[indexes.pollFirst()];
            int duration = indexes.size();
            for(int i = 0; i < duration ;i++){
                int candidateIndex = indexes.pollFirst();
                int[] candidateRow = matrix[candidateIndex];
                if(isMatchForFlip(currRow, candidateRow)){
                    tmpCnt++;
                }else{
                    indexes.add(candidateIndex);
                }
            }
            if(tmpCnt > maxCount) maxCount = tmpCnt;
        }
        return maxCount;
    }

    private boolean isMatchForFlip(int[] currRow, int[] candidateRow) {
        boolean flip = currRow[0] != candidateRow[0];
        for(int i = 1; i < currRow.length; i++){
            boolean ans = (currRow[i] == candidateRow[i]) ^ flip;
            if(!ans) return false;
        }
        return true;
    }

    public int maxEqualRowsAfterFlips_recursive(int[][] matrix){
       return Math.max(
                process_recursive(matrix, new int[matrix.length][matrix[0].length], 0, true),
                process_recursive(matrix, new int[matrix.length][matrix[0].length], 0, false)
        );
    }

    private int process_recursive(
            int[][] matrix,
            int[][] curr,
            int col,
            boolean flip) {
        for (int i = 0; i < matrix.length; i++) {
            curr[i][col] = flip ? matrix[i][col] ^ 1 : matrix[i][col];
        }
        if(col == matrix[0].length - 1){
            return countSameRows_recursive(curr);
        }else{
            return Math.max(
                    process_recursive(matrix, curr, col + 1, true),
                    process_recursive(matrix, curr, col + 1, false)
            );
        }
    }

    private int countSameRows_recursive(int[][] matrix) {
        int cnt = 0;
        for(int[] row: matrix){
            boolean matched = true;
            int seed = row[0];
            for(int i = 1; i < row.length;i++){
                if(row[i] != seed){
                    matched = false;
                    break;
                }
            }
            if(matched){
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[][] matrix = {{0},{1},{0},{0},{1},{1},{1},{1},{0},{1}};
        FlipColumns_1072 sol = new FlipColumns_1072();
        System.out.println(sol.maxEqualRowsAfterFlips(matrix));
    }
}
