package com.wackstr.leetcode.learn.array;

import java.util.Arrays;

public class DiagonalPrintArray {
    public int[] findDiagonalOrder(int[][] mat){
        int dx = 1; int dy = -1, k = 0;
        int[] left = {0, 0}, right = {0, 0}, curr;
        int[] arr = new int[mat.length * mat[0].length];
        boolean takeLeft = true;
        while(k < arr.length) {
            curr = takeLeft ?
                    new int[]{left[0], left[1]} :
                    new int[]{right[0], right[1]};
            while (curr[0] >= 0 && curr[0] < mat.length
                    && curr[1] >= 0 && curr[1] < mat[0].length) {
                arr[k] = mat[curr[0]][curr[1]];
                k++;
                curr[0] += dy;
                curr[1] += dx;
            }
            // move right
            if(right[1] < mat[0].length - 1) right[1]++;
            else right[0]++;
            // move left
            if(left[0] < mat.length - 1) left[0]++;
            else left[1]++;
            takeLeft = !takeLeft;
            dx = -dx;
            dy = -dy;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        DiagonalPrintArray sol = new DiagonalPrintArray();
        System.out.println(Arrays.toString(sol.findDiagonalOrder(mat)));
    }
}
