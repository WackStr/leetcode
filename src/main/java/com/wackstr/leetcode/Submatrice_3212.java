package com.wackstr.leetcode;

/*
2026-03-19 3212
 */
public class Submatrice_3212 {
    public int numberOfSubmatrices(char[][] grid){
        int m = grid[0].length;
        int[][] col = new int[2][m];
        int res = 0;
        for (char[] row : grid) {
            int x = 0;
            int y = 0;
            for(int j = 0; j < m; j++){
                if(row[j] == 'X') col[0][j]++;
                else if(row[j] == 'Y') col[1][j]++;
                x += col[0][j];
                y += col[1][j];
                if(x > 0 && x == y) res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        char[][] grid = {{'X', 'X'}, {'X', 'Y'}};
        Submatrice_3212 sol = new Submatrice_3212();
        System.out.println(sol.numberOfSubmatrices(grid));
    }
}
