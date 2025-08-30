package com.wackstr.leetcode;

import java.util.Arrays;

/*
2025-08-30
 */
public class ValidSudoku_36 {
        public boolean isValidSudoku(char[][] board) {
            int n = 9;
            boolean[] valid = new boolean[n];
            for(int i = 0; i < n; i++){
                Arrays.fill(valid, false);
                for(int j = 0; j < n; j++){
                    if(board[i][j] != '.') {
                        int index = (board[i][j] - '0') - 1;
                        if (valid[index]) return false;
                        valid[index] = true;
                    }
                }
            }
            for(int j = 0; j < n; j++){
                Arrays.fill(valid, false);
                for(int i = 0; i < n; i++){
                    if(board[i][j] != '.') {
                        int index = (board[i][j] - '0') - 1;
                        if (valid[index]) return false;
                        valid[index] = true;
                    }
                }
            }

            for(int i = 0; i < n; i += 3){
                for(int j = 0; j < n; j += 3){
                    Arrays.fill(valid, false);
                    for(int x = i; x < i + 3; x++){
                        for(int y = j; y < j + 3; y++){
                            if(board[x][y] != '.') {
                                int index = (board[x][y] - '0') - 1;
                                if (valid[index]) return false;
                                valid[index] = true;
                            }
                        }
                    }
                }
            }
            return true;
        }
}
