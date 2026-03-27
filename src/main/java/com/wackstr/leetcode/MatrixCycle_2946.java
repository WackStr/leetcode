package com.wackstr.leetcode;

/*
2026-03-27 2946
 */
public class MatrixCycle_2946 {
    public boolean areSimilar(int[][] mat, int k){
        int n = mat[0].length;

        // complete rotations leaves matrix unchanged
        if(k % n == 0) return true;

        int delta = k % n; // this is the net rotation done

        // check even row transformations
        for(int i = 0; i < mat.length; i+= 2)
            for(int j = 0; j < n; j++)
                if(mat[i][j] != mat[i][(j-delta+n) % n])
                    return false;

        // check for odd row transformations
        for(int i = 1; i < mat.length; i+= 2)
            for(int j = 0; j < n; j++)
                if(mat[i][j] != mat[i][(j + delta) % n])
                    return false;

        return true;
    }

    public static void main(String[] args) {
        int[][] mat = {{1,2}};
        int k = 1;
        MatrixCycle_2946 sol = new MatrixCycle_2946();
        System.out.println(sol.areSimilar(mat, k));
    }
}
