package com.wackstr.leetcode;

import java.util.Arrays;

/*
2025-08-31
 */
public class SolveSudoku_37 {

    private static final int GRID_SIZE = 3;
    private static final int BOARD_SIZE = GRID_SIZE*GRID_SIZE;
    private static final int CELL_COUNT = BOARD_SIZE * BOARD_SIZE;

    public void solveSudoku(char[][] board) {
        solve(board, 1);
    }

    public boolean solve(char[][] board, int coord){
        if(coord > CELL_COUNT) return true;
        int x = (coord-1) / BOARD_SIZE;
        int y = (coord-1) % BOARD_SIZE;
        if(board[x][y] != '.'){
            return solve(board, coord+1);
        }else{
            for(int i = 1; i < BOARD_SIZE + 1; i++){
                board[x][y] = (char) (i + '0');
                if(isValidSudoku(board, x, y) &&
                        solve(board, coord + 1))
                    return true;
            }
        }
        board[x][y] = '.';
        return false;
    }

    public static boolean isValidSudoku(
            char[][] board,
            int row, int col) {
        boolean[] valid = new boolean[BOARD_SIZE];
        if (isRowInvalid(board, row, valid)) return false;
        if (isColInvalid(board, col, valid)) return false;
        return !isGridInvalid(board, row, col, valid);
    }

    private static boolean isGridInvalid(
            char[][] board, int row, int col, boolean[] valid) {
        Arrays.fill(valid, false);
        int gridX = row/GRID_SIZE * GRID_SIZE;
        int gridY = col/GRID_SIZE * GRID_SIZE;
        for (int x = gridX; x < gridX + GRID_SIZE; x++) {
            for (int y = gridY; y < gridY + GRID_SIZE; y++) {
                if (board[x][y] != '.') {
                    int index = (board[x][y] - '0') - 1;
                    if (valid[index]) return true;
                    valid[index] = true;
                }
            }
        }
        return false;
    }

    private static boolean isColInvalid(
            char[][] board, int col, boolean[] valid) {
        Arrays.fill(valid, false);
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[i][col] != '.') {
                int index = (board[i][col] - '0') - 1;
                if (valid[index]) return true;
                valid[index] = true;
            }
        }
        return false;
    }

    private static boolean isRowInvalid(
            char[][] board, int row, boolean[] valid) {
        Arrays.fill(valid, false);
        for (int j = 0; j < BOARD_SIZE; j++) {
            if (board[row][j] != '.') {
                int index = (board[row][j] - '0') - 1;
                if (valid[index]) return true;
                valid[index] = true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','8','9','1','2'},
                {'6','7','2','1','9','5','3','4','8'},
                {'1','9','8','3','4','2','5','6','7'},
                {'8','5','9','7','6','1','4','2','3'},
                {'4','2','6','8','5','3','7','9','1'},
                {'7','1','3','9','2','4','8','5','6'},
                {'9','6','1','5','3','7','2','8','4'},
                {'2','8','7','4','1','9','6','3','5'},
                {'3','4','5','2','8','6','1','7','9'}
        };
        SolveSudoku_37 sol = new SolveSudoku_37();
        sol.solveSudoku(board);
        System.out.println(Arrays.deepToString(board));
    }
}
