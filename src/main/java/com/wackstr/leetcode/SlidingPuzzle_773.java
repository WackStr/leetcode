package com.wackstr.leetcode;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/*
2024-11-26
 */
public class SlidingPuzzle_773 {

    private static final String SOLVED_BOARD = "123450";
    private final int[][] NEXT_STEP_MAP = {
            {1,3},
            {0,2,4},
            {1,5},
            {0,4},
            {1,3,5},
            {2, 4}
    };

    public int slidingPuzzle(int[][] board) {
        String currBoard = getStringRepresentationOfBoard(board);
        int moveCount = 0;
        Queue<String> boards = new ArrayDeque<>();
        Set<String> visitedBoards = new HashSet<>();
        boards.add(currBoard);
        while(!boards.isEmpty()){
            int currQueueSize = boards.size();
            while(currQueueSize > 0){
                currBoard = boards.poll();

                if(isSolved(currBoard)) return moveCount;

                int freeSlotPosition = getFreeSlot(currBoard);

                for(int i : getSwaps(freeSlotPosition)){
                    String newBoard = swapBoard(currBoard, i, freeSlotPosition);
                    if(!visitedBoards.contains(newBoard)) {
                        boards.add(newBoard);
                        visitedBoards.add(newBoard);
                    }
                }
                currQueueSize--;
            }
            moveCount++;
        }
        return -1;

    }

    private String swapBoard(String currBoard, int i, int j) {
        String charA = currBoard.substring(i, i+1);
        String charB = currBoard.substring(j, j+1);
        StringBuilder sb = new StringBuilder(currBoard);
        sb.replace(i, i+1, charB);
        sb.replace(j, j+1, charA);
        return sb.toString();
    }

    private int[] getSwaps(int slotPosition) {
        return NEXT_STEP_MAP[slotPosition];
    }

    private int getFreeSlot(String currBoard) {
        for(int i = 0; i < currBoard.length(); i++){
            if(currBoard.charAt(i) == '0'){
                return i;
            }
        }
        return -1;
    }

    private boolean isSolved(String currBoard) {
        return currBoard.equals(SOLVED_BOARD);
    }

    private String getStringRepresentationOfBoard(int[][] board) {
        StringBuilder sb = new StringBuilder(board.length * board[0].length);
        for (int[] row : board) {
            for (int j = 0; j < board[0].length; j++) {
                sb.append(row[j]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[][] board = {{4,1,2}, {5, 0, 3}};
        SlidingPuzzle_773 sol = new SlidingPuzzle_773();
        System.out.println(sol.slidingPuzzle(board));
    }
}
