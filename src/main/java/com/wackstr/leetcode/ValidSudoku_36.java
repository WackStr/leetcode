package com.wackstr.leetcode;

import java.util.Arrays;

/*
2025-08-30
 */
public class ValidSudoku_36 {
    public boolean isValidSudoku(char[][] board) {
        int n = 10;
        boolean[] valid = new boolean[n];
        for(int i = 0; i < n; i++){
            Arrays.fill(valid, false);
            for(int j = 0; j < n; j++){
                valid[board[i][j] - '0'] = true;
            }
            for(int k = 0; k < n; k++){
                if(!valid[i]) return false;
            }
        }
        for(int j = 0; j < n; j++){
            Arrays.fill(valid, false);

        }

    }
}
