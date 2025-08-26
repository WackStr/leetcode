package com.wackstr.leetcode;

/*
2025-08-26
 */
public class MaximumArea_3000 {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int area = 0;
        int diag = 0;
        for(int[] dim : dimensions){
            int currDiag = dim[0] * dim[0] + dim[1]*dim[1];
            if(currDiag == diag){
                diag = currDiag;
                area = Math.max(area,dim[0] * dim[1]);
            }else if(currDiag > diag){
                diag = currDiag;
                area = dim[0] * dim[1];
            }
        }
        return area;
    }

    public static void main(String[] args) {
        int[][] dimensions = {{6,5},{8,6},{2,10},{8,1},{9,2},{3,5},{3,5}};
        MaximumArea_3000 sol = new MaximumArea_3000();
        System.out.println(sol.areaOfMaxDiagonal(dimensions));
    }
}
