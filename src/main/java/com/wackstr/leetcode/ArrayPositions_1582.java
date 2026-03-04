package com.wackstr.leetcode;

/*
2026-03-04 1582
 */
public class ArrayPositions_1582 {
    public int numSpecial(int[][] mat){
        int res = 0;
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 1){
                    boolean special = true;
                    for(int k = 0; k < mat.length; k++){
                        if(k != i && mat[k][j] == 1) {
                            special = false;
                            break;
                        }
                    }
                    if(special){
                        for(int l = 0; l < mat[0].length; l++){
                            if(l != j && mat[i][l] == 1){
                                special = false;
                                break;
                            }
                        }
                    }
                    if(special) res++;
                }
            }
        }
        return res;
    }
}
