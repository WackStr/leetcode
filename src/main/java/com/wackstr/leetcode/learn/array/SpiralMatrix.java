package com.wackstr.leetcode.learn.array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix){
        List<Integer> ls = new ArrayList<>();
        int limitX = (matrix[0].length + 1)/2 - 1;
        int limitY = (matrix.length+1)/2 - 1;
        int x = 0;
        int y = 0;
        while(x <= limitX && y <= limitY) {
            int i = x;
            int j = y;
            while (i < matrix[0].length - x) {
                ls.add(matrix[j][i]);
                i++;
            }
            i--;
            j++;
            if(j < matrix.length - x){
                while (j < matrix.length - x) {
                    ls.add(matrix[j][i]);
                    j++;
                }
                j--;
                i--;
                if(i >= x){
                    while (i >= x) {
                        ls.add(matrix[j][i]);
                        i--;
                    }
                    i++;
                    j--;
                    while (j > y) {
                        ls.add(matrix[j][i]);
                        j--;
                    }
                }
            }
            x++;
            y++;
        }
        return ls;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1,2},
                {3,4},
                {5,6}
        };
        SpiralMatrix sol = new SpiralMatrix();
        System.out.println(sol.spiralOrder(arr));
    }
}
