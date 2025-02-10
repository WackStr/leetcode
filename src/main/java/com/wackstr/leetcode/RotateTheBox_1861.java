package com.wackstr.leetcode;

import java.util.Arrays;

/*
2024-11-23
 */
public class RotateTheBox_1861 {

    private static final char STONE = '#';
    private static final char OBSTACLE = '*';
    private static final char EMPTY = '.';

    public char[][] rotateTheBox(char[][] box) {
        char[][] rotatedBox = getRotatedBox(box);
        applyGravity(rotatedBox);
        return rotatedBox;
    }

    private static char[][] getRotatedBox(char[][] box) {
        char[][] rotatedBox = new char[box[0].length][box.length];
        for(int row = 0; row < box.length; row++){
            rotateRow(box, rotatedBox, row);
        }
        return rotatedBox;
    }

    private static void rotateRow(char[][] box, char[][] rotatedBox, int row) {
        for(int i = 0; i < box[0].length; i++){
            char currItem = box[row][i];
            int mappedColumn = box.length - row - 1;
            switch (currItem){
                case STONE: rotatedBox[i][mappedColumn] = STONE; continue;
                case OBSTACLE: rotatedBox[i][mappedColumn] = OBSTACLE; continue;
                case EMPTY: rotatedBox[i][mappedColumn] = EMPTY; continue;
                default:
            }
        }
    }

    private void applyGravity(char[][] rotatedBox) {
        for(int col = 0; col < rotatedBox[0].length; col++){
            int fall = 0;
            for(int row = rotatedBox.length - 1; row >= 0; row --){
                char currItem = rotatedBox[row][col];
                if(currItem == EMPTY) {
                    fall++;
                }else if(currItem == OBSTACLE){
                    fall = 0;
                }else if(currItem == STONE && fall > 0){
                    rotatedBox[row][col] = EMPTY;
                    rotatedBox[row + fall][col] = STONE;
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] box = new char[][] {{'#','#','*','.','*','.'},
                {'#','#','#','*','.','.'},
                {'#','#','#','.','#','.'}};
        RotateTheBox_1861 sol = new RotateTheBox_1861();
        char[][] rotatedBox = sol.rotateTheBox(box);
        printBox(sol.rotateTheBox(box));
    }

    private static void printBox(char[][] box){
        for(char[] row : box){
            System.out.println(Arrays.toString(row));
        }
    }
}
