package com.wackstr.leetcode.learn.HashMap;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board){
        int[] rowMask  = new int[9];
        int[] colMask  = new int[9];
        int[] boxMask  = new int[9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') continue;
                int bit = 1 << (c - '1');
                int b   = (i / 3) * 3 + (j / 3);

                if ((rowMask[i] & bit) != 0
                        || (colMask[j] & bit) != 0
                        || (boxMask[b] & bit) != 0)
                    return false;

                rowMask[i] |= bit;
                colMask[j] |= bit;
                boxMask[b] |= bit;
            }
        }
        return true;
    }

}
