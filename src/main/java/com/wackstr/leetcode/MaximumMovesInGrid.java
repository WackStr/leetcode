package com.wackstr.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumMovesInGrid {
    public record Coordinate(int x, int y){}

    public int maxMoves(int[][] grid) {
        if (grid.length > 0 && grid[0].length > 0) {
            int maxScore = 0;
            Map<Coordinate, Integer> memo = new HashMap<>();
            for(int i = 0; i < grid.length; i++) {
                int currScore = maxMovesAgg(
                        new Coordinate(0, i),
                        memo,
                        grid,
                        0);
                if (currScore > maxScore) {
                    maxScore = currScore;
                }
                if(maxScore == grid[0].length - 1){
                    break;
                }
            }
            return maxScore;
        } else {
            return 0;
        }
    }

    private int maxMovesAgg(
            Coordinate coordinate,
            Map<Coordinate, Integer> memo,
            int[][] grid, int runningScore) {

        if(coordinate.x >= grid[0].length - 1) {
            return runningScore;
        }else if(memo.containsKey(coordinate)){
            return runningScore + memo.get(coordinate);
        }else{
            List<Integer> movements = List.of(-1, 0, 1);

            int maxScore = movements.stream().mapToInt(
                    delta -> navigate(
                            coordinate,
                            grid,
                            delta,
                            memo,
                            runningScore
                    )
            ).max().orElse(runningScore);
            memo.put(coordinate, maxScore - runningScore);
            return maxScore;
        }
    }

    private int navigate(
            Coordinate coordinate,
            int[][] grid,
            int yDelta,
            Map<Coordinate, Integer> memo,
            int runningScore
    ){
        int score = runningScore;
        Coordinate changeCoordinate = new Coordinate(coordinate.x() + 1, coordinate.y() + yDelta);
        if(canMove(coordinate, changeCoordinate, grid)){
            score = maxMovesAgg(
                    changeCoordinate,
                    memo,
                    grid,
                    1 + runningScore);
        }
        return score;
    }

    private boolean canMove(
            Coordinate coordinate,
            Coordinate changeCoordinate,
            int[][] grid) {

        int originalValue = getGridValue(coordinate, grid);
        int newValue = getGridValue(changeCoordinate, grid);
        return originalValue < newValue;
    }

    private int getGridValue(Coordinate coordinate, int[][] grid) {
        if(coordinate.x() < grid[0].length
                && coordinate.y() < grid.length && coordinate.x() >= 0
        && coordinate.y() >= 0){
            return grid[coordinate.y()][coordinate.x()];
        }else{
            return 0;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {
                {2,4,3,5},
                {5,4,9,3},
                {3,4,2,11},
                {10,9,13,15}
        };
        int[][] grid2 = {{3, 1}, {1, 5}
        };
        MaximumMovesInGrid sol = new MaximumMovesInGrid();
        int maxMoves = sol.maxMoves(grid);
        System.out.println(maxMoves);
    }
}
