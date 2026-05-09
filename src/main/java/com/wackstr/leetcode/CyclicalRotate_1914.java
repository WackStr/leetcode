package com.wackstr.leetcode;

import java.util.Arrays;

/*
2026-05-09
 */
public class CyclicalRotate_1914 {
    public int[][] rotateGrid(int[][] grid, int k){
        /*
        m x n matrix
        layer x has i = x or m - x - 1, j = x or n - x - 1
         */
        int m = grid.length;
        int n = grid[0].length;
        int layers = Math.min(grid.length, grid[0].length)/2;
        int count = m + n + m + n  + 4; // +8 to handle case 0
        int[][] res = new int[m][n];
        for (int layer = 0; layer < layers; layer++) {
            count -= 8; // count of current layer
            int netRotation = k % count;
            // starting point
            int[] src = {layer, layer};
            move(src, layer, m, n, netRotation); // move(i1, j1) for netRotations
            // ending point
            int[] dst = {layer, layer};

            for (int i = 0; i < count; i++) {
                // put grid[i0][j0] in res[i1][j1]
                res[dst[0]][dst[1]] = grid[src[0]][src[1]];
                move(src, layer, m, n);
                move(dst, layer, m, n);
            }
        }
        return res;
    }

    private void move(int[] dst, int layer, int m, int n, int k) {
        while(k-- > 0) move(dst, layer, m, n);
    }

    private void move(int[] dst, int layer, int m, int n) {
        int x = dst[0];
        int y = dst[1];
        if(x == layer){
            if(y == n - layer - 1){
                x++;
            }else{
                y++;
            }
        }else if(x == m - layer - 1){
            if(y == layer){
                x--;
            }else{
                y--;
            }
        }else if(y == layer){
            x--;
        }else{
            x++;
        }
        dst[0] = x;
        dst[1] = y;
    }

    public static void main(String[] args) {
        int[][] grid = {{10,1,4,8},{6,6,3,10},{7,4,7,10},{1,10,6,1},{2,1,1,10},{3,8,9,2},{7,1,10,10},{7,1,4,9},{2,2,4,2},{10,7,5,10}};
        int k = 1;
        CyclicalRotate_1914 sol = new CyclicalRotate_1914();
        System.out.println(Arrays.deepToString(sol.rotateGrid(grid, k)));
    }
}
