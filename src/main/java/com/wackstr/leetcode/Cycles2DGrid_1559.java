package com.wackstr.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/*
2026-04-26 1559
 */
public class Cycles2DGrid_1559 {
    private static final int[][] deltas = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public boolean containsCycle(char[][] grid){
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[][] parents = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(!visited[i][j] && cycleExists(i, j, grid, visited, parents)) return true;
            }
        }
        return false;
    }

    private boolean cycleExists(
            int i, int j, char[][] grid, boolean[][] visited, int[][] parents) {
        int n = grid.length;
        int m = grid[0].length;
        /*
        BFS here, take care to not revisit parent
         */
        Queue<Integer> stack = new LinkedList<>();
        stack.add(i*m + j);
        while(!stack.isEmpty()){
            int size = stack.size();
            while(size > 0){
                int curr = stack.poll();

                int currX = curr / m;
                int currY = curr % m;
                char currVal = grid[currX][currY];
                int parentX = parents[currX][currY] / m;
                int parentY = parents[currX][currY] % m;
                visited[currX][currY] = true;

                for (int[] delta : deltas) {
                    int newX = currX + delta[0];
                    int newY = currY + delta[1];
                    if(newX >= 0 && newX < n && newY >= 0 && newY < m && grid[newX][newY] == currVal && (newY != parentY || newX != parentX)){
                        if(visited[newX][newY]) return true;
                        parents[newX][newY] = curr;
                        stack.add(newX * m + newY);
                    }
                }
                size--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] grid = {{'d','b','b'},{'c','a','a'},{'b','a','c'},{'c','c','c'},{'d','d','a'}};
        Cycles2DGrid_1559 sol = new Cycles2DGrid_1559();
        System.out.println(sol.containsCycle(grid));
    }
}
